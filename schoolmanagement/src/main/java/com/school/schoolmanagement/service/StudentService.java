package com.school.schoolmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.schoolmanagement.entity.Student;
import com.school.schoolmanagement.repository.StudentRepository;
@Service
public class StudentService {
	@Autowired
	private StudentRepository repo;

	public String createNewStudent(Student student) {
		// TODO Auto-generated method stub
		 repo.save(student);
		 return "DataSaved";
		 
	}

	public Optional<Student> getstudent(Long id) {
		// TODO Auto-generated method stub
		return this.repo.findById(id);
	}

	public List<Student> getallstudentdetials() {
		// TODO Auto-generated method stub
		return this.repo.findAll();
	}

	public void deletestudent(Long id) {
		// TODO Auto-generated method stub
		this.repo.deleteById(id);
		
	}




}
