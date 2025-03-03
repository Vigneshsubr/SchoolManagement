package com.school.schoolmanagement.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.schoolmanagement.dto.ResponseDTO;
import com.school.schoolmanagement.service.ResultService;

@RestController
@RequestMapping("/api/v1/result")
public class ResultController {
	
	@Autowired
	private ResultService resultService;
	
	@GetMapping("/display/{studentId}")
	public ResponseDTO displayResult(@PathVariable Long studentId){
		return resultService.displayResult(studentId);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseDTO deleteResult(@PathVariable Long id) {
		return resultService.deleteResult(id);
		
	}
	
	@GetMapping("/total/{studentId}")
	public ResponseDTO calculateTotalMarks(@PathVariable Long studentId) {
		return resultService.calculateTotalMarks(studentId);
		
	}

}
