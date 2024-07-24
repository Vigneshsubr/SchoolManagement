package com.school.schoolmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.schoolmanagement.dto.ResponseDTO;
import com.school.schoolmanagement.entity.Salary;
import com.school.schoolmanagement.repository.SalaryRepository;
import com.school.schoolmanagement.util.Constants;

@Service
public class SalaryService {
	
	@Autowired 
	SalaryRepository salaryRepository;

	public ResponseDTO createSalary(Salary salary) {
		return ResponseDTO.builder().message(Constants.CREATED).data(salaryRepository.save(salary)).statusCode(200).build();
	}

	public ResponseDTO findsalary(Long id) {
		 return ResponseDTO.builder().message(Constants.FOUND).data(salaryRepository.findById(id)).statusCode(200).build();
	}
	
	

}
