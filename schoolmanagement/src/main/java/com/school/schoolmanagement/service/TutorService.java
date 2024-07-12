package com.school.schoolmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.schoolmanagement.entity.Tutor;
import com.school.schoolmanagement.repository.TutorRepository;
@Service
public class TutorService {
	@Autowired
	public TutorRepository repo;

	public String createTutor(Tutor tutor) {
		repo.save(tutor);
		return "Tutor created successfully";
		// TODO Auto-generated method stub
		
		
	}

	public List<Tutor> retriveTutor() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
