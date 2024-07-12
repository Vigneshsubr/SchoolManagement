package com.school.schoolmanagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.schoolmanagement.entity.Question;
import com.school.schoolmanagement.service.QuestionService;

@RestController
@RequestMapping("/api/question")
public class QuestionController {
	
	@Autowired
	QuestionService questionservice;
	
	@PostMapping("/create")
	public Question createQuestion(@RequestBody Question question) {
		return questionservice.crateQuestions(question);
		
	}
	
	@GetMapping("/retrive")
	public List<Question> getAllQuestion(){
		return questionservice.retriveQuestion();
	}
	
	@GetMapping("/{id}")
	public Optional<Question> getQuestionById(@PathVariable Long id){
		return questionservice.getQuestionById(id);
		
	}
	
	@GetMapping("category/{id}")
	public List<Question> getQuestionsByCategory(@PathVariable Long id){
		return questionservice.getQuestionsByCategory(id);
		
	}
	
	@DeleteMapping("delete/{id}")
	public void deleteQuesion(@PathVariable Long id) {
		questionservice.deleteQuestion(id);
	}

}
