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
import com.school.schoolmanagement.entity.School;
import com.school.schoolmanagement.service.SchoolService;

@RestController
@RequestMapping("/api/school")
public class SchoolController {
	@Autowired
	SchoolService schoolService;
	
	@PostMapping("/create")
	public ResponseDTO createNewScool(@RequestBody School school) {
		return schoolService.createNewSchool(school);
		
		
	}
	
	@GetMapping("/findall")
	public ResponseDTO getAllSchool(School school){
		return schoolService.getAllSchool(school);		
	}
	
	@DeleteMapping("/delete/{school}")
	public ResponseDTO delete(@PathVariable  Long school) {
		return schoolService.deleteSchool(school);
	}

}
