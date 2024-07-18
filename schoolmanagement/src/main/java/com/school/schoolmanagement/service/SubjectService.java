package com.school.schoolmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.schoolmanagement.dto.ResponseDTO;
import com.school.schoolmanagement.entity.Subject;
import com.school.schoolmanagement.repository.SubjectRepository;
import com.school.schoolmanagement.util.Constants;

@Service

public class SubjectService {
	@Autowired
	public SubjectRepository subjectRepository;

	public ResponseDTO createSubject(Subject subject) {
		return ResponseDTO.builder().message(Constants.CREATED).data(subjectRepository.save(subject)).statusCode(200).build();
	}

	public ResponseDTO retrivesubject() {
		return ResponseDTO.builder().message(Constants.RETRIEVED).data(subjectRepository.findAll()).statusCode(200).build();
		
	}

	public ResponseDTO deleteSubject(Long id) {
		subjectRepository.deleteById(id);
		return ResponseDTO.builder().message(Constants.REMOVED).statusCode(200).build();
		
	}

}
