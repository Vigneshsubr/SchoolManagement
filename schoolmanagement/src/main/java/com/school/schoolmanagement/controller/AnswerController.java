package com.school.schoolmanagement.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.schoolmanagement.entity.Answer;

import com.school.schoolmanagement.service.AnswerService;


@RestController
@RequestMapping("/answers")
public class AnswerController {
	@Autowired
	private AnswerService answerService;
	
	@GetMapping("/display/{studentId}")
	public List<Answer> displayAnswer(@PathVariable Long studentId) {
		return answerService.displayAnswers(studentId);
		
	}
	
	


}
