package com.school.schoolmanagement.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.schoolmanagement.dto.ResponseDTO;
import com.school.schoolmanagement.repository.ResultRepository;
import com.school.schoolmanagement.util.Constants;

@Service
public class ResultService {
	
	@Autowired
	private ResultRepository resultRepository;

	public ResponseDTO displayResult(Long studentId) {
		 return ResponseDTO.builder().message(Constants.RETRIEVED).data(resultRepository.findByStudentId(studentId)).statusCode(200).build();
		 
	}

	public ResponseDTO deleteResult(Long id) {
		 resultRepository.deleteById(id);
		 return ResponseDTO.builder().message(Constants.REMOVED).statusCode(200).build();
	}

	public ResponseDTO calculateTotalMarks(Long studentId) {
		// TODO Auto-generated method stub
		return ResponseDTO.builder().message(Constants.FOUND).data(resultRepository.calculateTotalByStudentId(studentId)).statusCode(200).build();
	}



}
