package com.school.schoolmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.schoolmanagement.dto.ResponseDTO;
import com.school.schoolmanagement.entity.Question;
import com.school.schoolmanagement.service.QuestionService;

@RestController
@RequestMapping("/api/question")
public class QuestionController {
	
	@Autowired
	QuestionService questionservice;
	
	@PostMapping("/create")
	public ResponseDTO createQuestion(@RequestBody Question question) {
		return questionservice.crateQuestions(question);
		
	}
	
	@GetMapping("/retrive")
	public ResponseDTO getAllQuestion(){
		return questionservice.retriveQuestion();
	}
	
	@GetMapping("/{id}")
	public ResponseDTO getQuestionById(@PathVariable Long id){
		return questionservice.getQuestionById(id);
		
	}
	
	@GetMapping("category/{id}")
	public ResponseDTO getQuestionsByCategory(@PathVariable Long id){
		return questionservice.getQuestionsByCategory(id);
		
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseDTO deleteQuesion(@PathVariable Long id) {
		return questionservice.deleteQuestion(id);
	}

}
