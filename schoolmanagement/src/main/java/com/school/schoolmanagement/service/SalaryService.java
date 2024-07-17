package com.school.schoolmanagement.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.schoolmanagement.entity.Salary;
import com.school.schoolmanagement.repository.SalaryRepository;

@Service
public class SalaryService {
	
	@Autowired 
	SalaryRepository salaryRepository;

	public Salary createSalary(Salary salary) {
		return salaryRepository.save(salary);
	}

	public Optional<Salary> findsalary(Long id) {
		 return salaryRepository.findById(id);
	}
	
	

}
