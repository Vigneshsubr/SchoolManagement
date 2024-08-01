package com.school.schoolmanagement.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.school.schoolmanagement.dto.ResponseDTO;
import com.school.schoolmanagement.dto.StudentDTO;
import com.school.schoolmanagement.entity.Student;
import com.school.schoolmanagement.repository.StudentRepository;
import com.school.schoolmanagement.util.Constants;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;

	public ResponseDTO createNewStudent(Student student) {

		return ResponseDTO.builder().message(Constants.CREATED).data(studentRepository.save(student)).statusCode(200)
				.build();

	}

	public ResponseDTO getstudent(Long id) {

		return ResponseDTO.builder().message(Constants.RETRIEVED).data(studentRepository.findById(id)).statusCode(200)
				.build();
	}

	public ResponseDTO getallstudentdetials() {

		return ResponseDTO.builder().message(Constants.RETRIEVED).data(studentRepository.findAll()).statusCode(200)
				.build();
	}

	public ResponseDTO deletestudent(Long id) {

		studentRepository.deleteById(id);
		return ResponseDTO.builder().message(Constants.REMOVED).statusCode(200).build();

	}

	public ResponseDTO updateStudent(Long id, Student student) {

		Student updateStudent = studentRepository.findById(id).orElseThrow();

		updateStudent.setName(student.getName());
		updateStudent.setSchool(student.getSchool());
		updateStudent.setAddress(student.getAddress());

		return ResponseDTO.builder().message(Constants.MODIFIED).data(studentRepository.save(updateStudent))
				.statusCode(200).build();

	}

//	public List<Student> searchStudent(String name, Long schoolId, String address) {
//		// TODO Auto-generated method stub
//		return repo.searchStudent(name, schoolId, address);
//	}

	public ResponseDTO searchStudentByName(String name) {
		return ResponseDTO.builder().message(Constants.FOUND).data(studentRepository.findStudentByName(name))
				.statusCode(200).build();
	}

	public ResponseDTO searchStudentByAddress(String address) {
		return ResponseDTO.builder().message(Constants.FOUND).data(studentRepository.findStudentByAddress(address))
				.statusCode(200).build();
	}

	public ResponseDTO getStudents(String search, Integer page, Integer size, String sortField, String sortDirection) {

		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending()
				: Sort.by(sortField).descending();
		Pageable pageable = PageRequest.of(page != null ? page : 0, size != null ? size : 6, sort);

		Page<Student> studentPage = studentRepository.findByNameContaining(search, pageable);

		List<StudentDTO> studentDTOs = new ArrayList<>();

		for (Student student : studentPage) {
			StudentDTO dto = new StudentDTO();
			dto.setAddress(student.getAddress());
			dto.setName(student.getName());
			dto.setSchoolId(student.getId());
			studentDTOs.add(dto);
		}
		return ResponseDTO.builder().message(Constants.FOUND).data(studentDTOs).statusCode(200).build();

	}

}
