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

	public void updateStudent(Long id,Student student) {
		// TODO Auto-generated method stub
		Student updateStudent=repo.findById(id).orElseThrow();

		updateStudent.setName(student.getName());
		updateStudent.setSchool(student.getSchool());
		updateStudent.setAddress(student.getAddress());
		
		repo.save(updateStudent);
		
			
		
	}

//	public List<Student> searchStudent(String name, Long schoolId, String address) {
//		// TODO Auto-generated method stub
//		return repo.searchStudent(name, schoolId, address);
//	}

	public List<Student> searchStudentByName(String name) {
		// TODO Auto-generated method stub
		return repo.findStudentByName(name);
	}

	public List<Student> searchStudentByAddress(String address) {
		// TODO Auto-generated method stub
		return repo.findStudentByAddress(address);
	}

	public List<StudentDTO> getStudents(String search, Integer page, Integer size, String sortField,String sortDirection) {
		// TODO Auto-generated method stub

		Sort sort=Sort.by(sortField!=null ? sortField:"defaultSortField");
		sort= sortDirection!=null&&sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name())? sort.ascending():sort.descending();
		Pageable pageable=  PageRequest.of(page != null ? page : 0, size != null ? size : 6, sort);
		
		Page<Student> studentPage = repo.findByNameContaining(search, pageable);
		
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
