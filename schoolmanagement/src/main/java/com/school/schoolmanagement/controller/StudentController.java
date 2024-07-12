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

import com.school.schoolmanagement.entity.Student;
import com.school.schoolmanagement.service.StudentService;

@RestController
@RequestMapping("student")
public class StudentController {
	@Autowired
	private StudentService service;
	
	@PostMapping("/insert")
	public String createNewStudent(@RequestBody Student student) {
		return this.service.createNewStudent(student);
	}
	
	@GetMapping("/{id}")
	public Optional<Student> getstudent(@PathVariable Long id) {
		return this.service.getstudent(id);
	}
	
	@GetMapping("/getallstudents")
		public List<Student> getallstudent(){
		return service.getallstudentdetials();

	}
	
	@DeleteMapping("/deletestudent{id}")
	public void  delete(@PathVariable Long id) {
		this.service.deletestudent(id);
		
	}
	
	
	
	}
	


	
