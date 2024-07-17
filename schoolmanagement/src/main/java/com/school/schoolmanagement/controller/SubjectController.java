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

import com.school.schoolmanagement.entity.Subject;
import com.school.schoolmanagement.service.SubjectService;

@RestController
@RequestMapping("/api/subject")
public class SubjectController {
	@Autowired
	public SubjectService subjectService;
	
	@PostMapping("/create")
	public String createSubject(@RequestBody Subject subject) {
		return this.subjectService.createSubject(subject);
	}
	
	@GetMapping("/retrive")
	public List<Subject> retrivesubject(){
		return this.subjectService.retrivesubject();
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteSubject(@PathVariable Long id) {
		subjectService.deleteSubject(id);
	}

}
