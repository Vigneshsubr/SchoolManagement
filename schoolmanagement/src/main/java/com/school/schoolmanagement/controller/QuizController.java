package com.school.schoolmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import com.school.schoolmanagement.dto.QuestionDTO;
import com.school.schoolmanagement.dto.QuizSubmissionDTO;
import com.school.schoolmanagement.dto.ResponseDTO;
import com.school.schoolmanagement.service.QuizService;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {
	@Autowired
	QuizService quizService;
	
	@PostMapping("/create")
	public ResponseDTO createQuiz(@RequestParam Long id,@RequestParam int numQ,@RequestParam String title){
		return quizService.createQuiz(id,numQ,title);
		
	}
	
	@GetMapping("/find/{id}")
	public ResponseDTO getQuizQuestion(@PathVariable Long id){
		return quizService.getQuizQuestions(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseDTO deleteQuiz(@PathVariable Long id){
		return quizService.deleteQuiz(id);
		
	}
	
    @PostMapping("/submit")
    public ResponseDTO submitQuiz(@RequestBody QuizSubmissionDTO submissionDTO) {
         return quizService.submitQuiz(submissionDTO);
    }
    
    
    @GetMapping("/result")
    public ResponseDTO getResult(@RequestParam Long studentId, @RequestParam Long quizId) {
        return quizService.calculateResult(studentId, quizId);
    }
    
//    @GetMapping("/result")
//    public Integer getResult(@RequestParam Long studentId, @RequestParam Long quizId) {
//        return quizService.calculateResult(studentId, quizId);
//    }

}
 