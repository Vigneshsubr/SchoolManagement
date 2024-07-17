package com.school.schoolmanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.school.schoolmanagement.dto.StudentDTO;
import com.school.schoolmanagement.entity.Student;
import com.school.schoolmanagement.repository.StudentRepository;
@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;

	public String createNewStudent(Student student) {
		// TODO Auto-generated method stub
		studentRepository.save(student);
		 return "DataSaved";
		 
	}

	public Optional<Student> getstudent(Long id) {
		// TODO Auto-generated method stub
		return this.studentRepository.findById(id);
	}

	public List<Student> getallstudentdetials() {
		// TODO Auto-generated method stub
		return this.studentRepository.findAll();
	}

	public void deletestudent(Long id) {
		// TODO Auto-generated method stub
		this.studentRepository.deleteById(id);
		
	}

	public void updateStudent(Long id,Student student) {
		// TODO Auto-generated method stub
		Student updateStudent=studentRepository.findById(id).orElseThrow();

		updateStudent.setName(student.getName());
		updateStudent.setSchool(student.getSchool());
		updateStudent.setAddress(student.getAddress());
		
		studentRepository.save(updateStudent);
		
			
		
	}

//	public List<Student> searchStudent(String name, Long schoolId, String address) {
//		// TODO Auto-generated method stub
//		return repo.searchStudent(name, schoolId, address);
//	}

	public List<Student> searchStudentByName(String name) {
		// TODO Auto-generated method stub
		return studentRepository.findStudentByName(name);
	}

	public List<Student> searchStudentByAddress(String address) {
		// TODO Auto-generated method stub
		return studentRepository.findStudentByAddress(address);
	}

	public List<StudentDTO> getStudents(String search, Integer page, Integer size, String sortField,String sortDirection) {
		// TODO Auto-generated method stub

		Sort sort= sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name())? Sort.by(sortField).ascending():Sort.by(sortField).descending();
		Pageable pageable=  PageRequest.of(page != null ? page : 0, size != null ? size : 6, sort);
		
		Page<Student> studentPage = studentRepository.findByNameContaining(search, pageable);
		
		List<StudentDTO> studentDTOs=new ArrayList<>();
		
		for(Student student: studentPage) {
			StudentDTO dto=new StudentDTO();
			dto.setAddress(student.getAddress());
			dto.setName(student.getName());
			dto.setSchoolId(student.getId());
			studentDTOs.add(dto);
		}
		return studentDTOs;

	     

	}
	

}
