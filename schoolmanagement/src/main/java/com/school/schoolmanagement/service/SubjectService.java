package com.school.schoolmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.schoolmanagement.entity.Subject;
import com.school.schoolmanagement.repository.SubjectRepository;

@Service

public class SubjectService {
	@Autowired
	public SubjectRepository subjectRepository;

	public String createSubject(Subject subject) {
		// TODO Auto-generated method stub
		this.subjectRepository.save(subject);
		return "subject created successfully";
	}

	public List<Subject> retrivesubject() {
		// TODO Auto-generated method stub
		return this.subjectRepository.findAll();
		
	}

	public String deleteSubject(Long id) {
		subjectRepository.deleteById(id);
		return "Subject Deleted Successfully";
		// TODO Auto-generated method stub
		
	}

}
