package com.school.schoolmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.schoolmanagement.entity.School;
import com.school.schoolmanagement.service.SchoolService;

@RestController
@RequestMapping("/school")
public class SchoolController extends StudentController {
	@Autowired
	SchoolService service;
	
	@PostMapping("/create")
	public String createNewScool(@RequestBody School school) {
		service.createNewSchool(school);
		return "school created";
		
	}
	
	@GetMapping("/getschool")
	public List<School> getAllSchool(School school){
		return service.getAllSchool(school);		
	}
	
	@DeleteMapping("/delete{id}")
	public void delete(@PathVariable  Long school) {
		 service.deleteSchool(school);
	}

}