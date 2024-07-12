package com.school.schoolmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.schoolmanagement.entity.School;
import com.school.schoolmanagement.repository.SchoolRepository;

@Service
public class SchoolService {

@Autowired
public SchoolRepository repo;

	public void createNewSchool(School school) {
		// TODO Auto-generated method stub
		repo.save(school);
		
	}

	public List<School> getAllSchool(School school) {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public void deleteSchool(Long school) {
		// TODO Auto-generated method stub
		repo.deleteById(school);
		
	}
	

}