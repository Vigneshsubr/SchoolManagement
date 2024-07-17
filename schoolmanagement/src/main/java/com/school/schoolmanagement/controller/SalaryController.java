package com.school.schoolmanagement.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.schoolmanagement.entity.Salary;
import com.school.schoolmanagement.service.SalaryService;

@RestController
@RequestMapping("/api/salary")
public class SalaryController {
	
	@Autowired
	private SalaryService salaryService;
	
	
	@PostMapping("/create")
	public Salary createSalary(@RequestBody Salary salary) {
		
		return salaryService.createSalary(salary);
		
	}
	
	@GetMapping("/findsalary/{id}")
	public Optional<Salary> findsalary(@PathVariable Long id) {
		return salaryService.findsalary(id);
		
	}

}
