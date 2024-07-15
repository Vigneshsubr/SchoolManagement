package com.school.schoolmanagement.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.schoolmanagement.entity.Result;
import com.school.schoolmanagement.repository.ResultRepository;

@Service
public class ResultService {
	
	@Autowired
	private ResultRepository resultRepository;

	public Optional<Result> displayResult(Long studentId) {
		// TODO Auto-generated method stub
		 return resultRepository.findByStudentId(studentId);
		 
	}

	public String deleteResult(Long id) {
		// TODO Auto-generated method stub
		 resultRepository.deleteById(id);
		 return "Deleted Successfully";
	}

	public Integer calculateTotalMarks(Long studentId) {
		// TODO Auto-generated method stub
		return resultRepository.calculateTotalByStudentId(studentId);
	}



}
