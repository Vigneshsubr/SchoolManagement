package com.school.schoolmanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.school.schoolmanagement.dto.AnswerDTO;
import com.school.schoolmanagement.dto.QuestionDTO;
import com.school.schoolmanagement.dto.QuizSubmissionDTO;
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
	public ResponseEntity<String> createQuiz(Long id, int numQ, String title ) {
		// TODO Auto-generated method stub
		List<Question> questions= questionRepository.findRandomQuestionBysubject_id(id,numQ);
		
		Quiz quiz=new Quiz();
		quiz.setTitle(title);
		quiz.setQuestion(questions);
		quizRepository.save(quiz);
		
		return new ResponseEntity<>("Success",HttpStatus.CREATED);
	}
	
	
//get quiz questions

	  public ResponseEntity<List<QuestionDTO>> getQuizQuestions(Long id) {
		// TODO Auto-generated method stub
		  Optional<Quiz> quiz=quizRepository.findById(id);
		  List<Question> questionFromDB=quiz.get().getQuestion();
		  List<QuestionDTO> questionForUser=new ArrayList<>();
		  for(Question q: questionFromDB) {
			  QuestionDTO qw=new QuestionDTO(q.getId(),q.getQuestion(),q.getOption1(),q.getOption2());
			  questionForUser.add(qw);  
			  
		  }
		return new ResponseEntity<>(questionForUser,HttpStatus.OK);
	}
	  
	  
//Delete quiz
	public ResponseEntity<List<Quiz>> deleteQuiz(Long id) {
		// TODO Auto-generated method stub
		quizRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.IM_USED);
	}


	//submit quiz
	public Result submitQuiz(QuizSubmissionDTO submissionDTO) {
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
		return null;
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
	
	
	
	public Result calculateResult(Long studentId, Long quizId) {
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

        resultRepository.save(result);

        return result;
    }
	
	

	
}

