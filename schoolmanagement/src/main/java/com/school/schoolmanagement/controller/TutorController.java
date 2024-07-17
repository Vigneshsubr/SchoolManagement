package com.school.schoolmanagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.schoolmanagement.entity.Tutor;
import com.school.schoolmanagement.service.TutorService;

@RestController
@RequestMapping("/api/tutor")
public class TutorController {
	
	@Autowired
	public TutorService tutorService;
	
	@PostMapping("/create")
	public String createTutor(@RequestBody Tutor tutor) {
		return tutorService.createTutor(tutor);
	}
	
	@GetMapping("/findall")
	public List<Tutor> retrive(){
		return tutorService.retriveTutor();
	}
	
	@GetMapping("/find/{id}")
	public Optional<Tutor> tutordetials(@PathVariable Long id){
		return tutorService.tutordetials(id);
	}
	
	

}
