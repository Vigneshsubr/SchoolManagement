package com.school.schoolmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.schoolmanagement.entity.Tutor;
import com.school.schoolmanagement.service.TutorService;

@RestController
@RequestMapping("/tutor")
public class TutorController {
	
	@Autowired
	public TutorService service;
	
	@PostMapping("/create-tutor")
	public String createTutor(@RequestBody Tutor tutor) {
		return service.createTutor(tutor);
	}
	
	@GetMapping("/list")
	public List<Tutor> retrive(){
		return service.retriveTutor();
	}
	
	

}