package com.school.schoolmanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.schoolmanagement.dto.AnswerDTO;
import com.school.schoolmanagement.dto.QuestionDTO;
import com.school.schoolmanagement.dto.QuizSubmissionDTO;
import com.school.schoolmanagement.dto.ResponseDTO;
import com.school.schoolmanagement.entity.Answer;
import com.school.schoolmanagement.entity.Question;
import com.school.schoolmanagement.entity.Quiz;
import com.school.schoolmanagement.entity.Result;
import com.school.schoolmanagement.entity.Student;
import com.school.schoolmanagement.repository.AnswerRepository;
import com.school.schoolmanagement.repository.QuestionRepository;
import com.school.schoolmanagement.repository.QuizRepository;
import com.school.schoolmanagement.repository.ResultRepository;
import com.school.schoolmanagement.repository.StudentRepository;
import com.school.schoolmanagement.util.Constants;

@Service
public class QuizService {
	
	@Autowired
	QuizRepository quizRepository;
	
	@Autowired
	QuestionRepository questionRepository;
	
	@Autowired
	AnswerRepository answerRepository;
//	
	@Autowired
	ResultRepository resultRepository;
	
	@Autowired
	StudentRepository studentRepository;
	

//creating quiz
	public ResponseDTO createQuiz(Long id, int numQ, String title ) {
		// TODO Auto-generated method stub
		List<Question> questions= questionRepository.findRandomQuestionBysubject_id(id,numQ);
		
		Quiz quiz=new Quiz();
		quiz.setTitle(title);
		quiz.setQuestion(questions);
		return ResponseDTO.builder().message(Constants.CREATED).data(quizRepository.save(quiz)).statusCode(200).build();
	}
	
	
//get quiz questions

	  public ResponseDTO getQuizQuestions(Long id) {
		// TODO Auto-generated method stub
		  Optional<Quiz> quiz=quizRepository.findById(id);
		  List<Question> questionFromDB=quiz.get().getQuestion();
		  List<QuestionDTO> questionForUser=new ArrayList<>();
		  for(Question q: questionFromDB) {
			  QuestionDTO qw=new QuestionDTO(q.getId(),q.getQuestion(),q.getOption1(),q.getOption2());
			  questionForUser.add(qw);  
			  
		  }
		return ResponseDTO.builder().message(Constants.CREATED).data(questionForUser).statusCode(200).build();
	}
	  
	  
//Delete quiz
	public ResponseDTO deleteQuiz(Long id) {
		// TODO Auto-generated method stub
		quizRepository.deleteById(id);
		return ResponseDTO.builder().message(Constants.REMOVED).statusCode(200).build();
	}


	//submit quiz
	public ResponseDTO submitQuiz(QuizSubmissionDTO submissionDTO) {
		// TODO Auto-generated method stub
		Student student=studentRepository.findById(submissionDTO.getStudentId()).orElseThrow();
		Quiz quiz=quizRepository.findById(submissionDTO.getQuizId()).orElseThrow();
		
		for(AnswerDTO answerDTO : submissionDTO.getAnswers()) {
			
			Question question = questionRepository.findById(answerDTO.getQuestionId()).orElseThrow();
		    Answer answer=new Answer();
			answer.setStudent(student);
			answer.setQuiz(quiz);
			answer.setQuestion(question);
			answer.setSelectedAnswer(answerDTO.getSelectedAnswer());
			
			answerRepository.save(answer);
			
			
		}	
		return ResponseDTO.builder().message(Constants.SUBMITED).statusCode(200).build();
	}
	
//	
//	public Integer calculateResult(Long studentId, Long quizId) {
//        List<Answer> answers = answerRepository.findByStudentIdAndQuizId(studentId, quizId);
//
//        int totalQuestions = answers.size();
//        int correctAnswers = 0;
//
//        for (Answer answer : answers) {
//            if (answer.getSelectedAnswer().equals(answer.getQuestion().getRightAnswer())) {
//                correctAnswers++;
//            }
//        }
//
//        int totalMarks = correctAnswers; // Assuming each question carries 1 mark
//
//        Result result = new Result();
//        result.setStudent(answers.get(0).getStudent());
//        result.setQuiz(answers.get(0).getQuiz());
//        result.setTotalQuestions(totalQuestions);
//        result.setCorrectAnswers(correctAnswers);
//        result.setTotalMarks(totalMarks);
//
//        resultRepository.save(result);
//
//        return Integer;
//    }
	
	
	
	public ResponseDTO calculateResult(Long studentId, Long quizId) {
        List<Answer> answers = answerRepository.findByStudentIdAndQuizId(studentId, quizId);

        int totalQuestions = answers.size();
        int correctAnswers = 0;

        for (Answer answer : answers) {
            if (answer.getSelectedAnswer().equals(answer.getQuestion().getRightAnswer())) {
                correctAnswers++;
            }
        }

        int totalMarks = correctAnswers; // Assuming each question carries 1 mark

        Result result = new Result();
        result.setStudent(answers.get(0).getStudent());
        result.setQuiz(answers.get(0).getQuiz());
        result.setTotalQuestions(totalQuestions);
        result.setCorrectAnswers(correctAnswers);
        result.setTotalMarks(totalMarks);


        return ResponseDTO.builder().message(Constants.CREATED).data(resultRepository.save(result)).statusCode(200).build();
    }
	
	

	
}

