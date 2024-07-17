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
	private StudentService studentService;
	
	@PostMapping("/create")
	public String createNewStudent(@RequestBody Student student) {
		return this.studentService.createNewStudent(student);
	}
	
	@GetMapping("/findstudent/{id}")
	public Optional<Student> getstudent(@PathVariable Long id) {
		return this.studentService.getstudent(id);
	}
	
	@GetMapping("/findallstudent")
		public List<Student> getallstudent(){
		return studentService.getallstudentdetials();

	}
	
	@DeleteMapping("/deletestudent/{id}")
	public void  delete(@PathVariable Long id) {
		this.studentService.deletestudent(id);
		
	}
	
	@PutMapping("/modifystudent/{id}")
		public void updateStudent(@PathVariable Long  id,@RequestBody Student student) {
		studentService.updateStudent(id,student);
		
	}
//	
//	@GetMapping("/search")
//	public List<Student> searchStudent(@RequestParam(required=false) String name,@RequestParam(required=false) Long schoolId,@RequestParam(required=false) String address){
//		return service.searchStudent(name,schoolId,address);
//	}
	
	@GetMapping("/search/name")
	public List<Student> searchStudent(@RequestParam String name){
		return studentService.searchStudentByName(name);
		
	}
	
	@GetMapping("/search/address")
	public List<Student> searchStudentaddress(@RequestParam String address ){
		return studentService.searchStudentByAddress(address);
	}
	
	@GetMapping("/search")
	public List<StudentDTO> getStudents(
			@RequestParam(required = false) String search,
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size,
            @RequestParam(required = false, defaultValue = "name") String sortField,
            @RequestParam(required = false, defaultValue = "asc") String sortDirection) {
       return studentService.getStudents(search, page, size, sortField, sortDirection);
    }
	
	
	
	}
	


	
