package com.school.schoolmanagement.controller;

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
import com.school.schoolmanagement.dto.ResponseDTO;
import com.school.schoolmanagement.entity.Student;
import com.school.schoolmanagement.service.StudentService;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/create")
	public ResponseDTO createNewStudent(@RequestBody Student student) {
		return studentService.createNewStudent(student);
	}
	
	@GetMapping("/findstudent/{id}")
	public ResponseDTO getstudent(@PathVariable Long id) {
		return studentService.getstudent(id);
	}
	
	@GetMapping("/findallstudent")
		public ResponseDTO getallstudent(){
		return studentService.getallstudentdetials();

	}
	
	@DeleteMapping("/deletestudent/{id}")
	public ResponseDTO  delete(@PathVariable Long id) {
		return studentService.deletestudent(id);
		
	}
	
	@PutMapping("/modifystudent/{id}")
		public ResponseDTO updateStudent(@PathVariable Long  id,@RequestBody Student student) {
		return studentService.updateStudent(id,student);
		
	}
//	
//	@GetMapping("/search")
//	public List<Student> searchStudent(@RequestParam(required=false) String name,@RequestParam(required=false) Long schoolId,@RequestParam(required=false) String address){
//		return service.searchStudent(name,schoolId,address);
//	}
	
	@GetMapping("/search/name")
	public ResponseDTO searchStudent(@RequestParam String name){
		return studentService.searchStudentByName(name);
		
	}
	
	@GetMapping("/search/address")
	public ResponseDTO searchStudentaddress(@RequestParam String address ){
		return studentService.searchStudentByAddress(address);
	}
	
	@GetMapping("/search")
	public ResponseDTO getStudents(
			@RequestParam(required = false) String search,
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size,
            @RequestParam(required = false, defaultValue = "name") String sortField,
            @RequestParam(required = false, defaultValue = "asc") String sortDirection) {
       return studentService.getStudents(search, page, size, sortField, sortDirection);
    }
	
	
	
	}
	


	
