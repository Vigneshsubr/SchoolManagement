package com.school.schoolmanagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.school.schoolmanagement.dto.StudentDTO;
import com.school.schoolmanagement.entity.Student;
import com.school.schoolmanagement.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {
	@Autowired
	private StudentService service;
	
	@PostMapping("/insert")
	public String createNewStudent(@RequestBody Student student) {
		return this.service.createNewStudent(student);
	}
	
	@GetMapping("/{id}")
	public Optional<Student> getstudent(@PathVariable Long id) {
		return this.service.getstudent(id);
	}
	
	@GetMapping("/getallstudents")
		public List<Student> getallstudent(){
		return service.getallstudentdetials();

	}
	
	@DeleteMapping("/deletestudent{id}")
	public void  delete(@PathVariable Long id) {
		this.service.deletestudent(id);
		
	}
	
	@PutMapping("/modifystudent/{id}")
		public void updateStudent(@PathVariable Long  id,@RequestBody Student student) {
		service.updateStudent(id,student);
		
	}
//	
//	@GetMapping("/search")
//	public List<Student> searchStudent(@RequestParam(required=false) String name,@RequestParam(required=false) Long schoolId,@RequestParam(required=false) String address){
//		return service.searchStudent(name,schoolId,address);
//	}
	
	@GetMapping("/search/studentname")
	public List<Student> searchStudent(@RequestParam String name){
		return service.searchStudentByName(name);
		
	}
	
	@GetMapping("/search/studentaddress")
	public List<Student> searchStudentaddress(@RequestParam String address ){
		return service.searchStudentByAddress(address);
	}
	
	@GetMapping("/search")
	
	public List<StudentDTO> getStudents(
			@RequestParam(required = false) String search,
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size,
            @RequestParam(required = false, defaultValue = "name") String sortField,
            @RequestParam(required = false, defaultValue = "asc") String sortDirection) {
       return service.getStudents(search, page, size, sortField, sortDirection);
    }
	
	
	
	}
	


	
