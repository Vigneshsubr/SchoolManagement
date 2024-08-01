package com.school.schoolmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.schoolmanagement.dto.ResponseDTO;
import com.school.schoolmanagement.service.AnswerService;


@RestController
@RequestMapping("/api/v1/answers")
public class AnswerController {
	@Autowired
	private AnswerService answerService;
	
	@GetMapping("/display/{studentId}")
	public ResponseDTO displayAnswer(@PathVariable Long studentId) {
		return answerService.displayAnswers(studentId);
		
	}
	
}
