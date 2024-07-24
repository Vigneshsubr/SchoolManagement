package com.school.schoolmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.school.schoolmanagement.dto.ResponseDTO;
import com.school.schoolmanagement.entity.School;
import com.school.schoolmanagement.repository.SchoolRepository;
import com.school.schoolmanagement.util.Constants;

@Service
public class SchoolService {

@Autowired
public SchoolRepository schoolRepository;

	public ResponseDTO createNewSchool(School school) {
		schoolRepository.save(school);
		return ResponseDTO.builder().message(Constants.CREATED).data(this.schoolRepository.save(school)).statusCode(201).build();
		
	}

	public ResponseDTO getAllSchool(School school) {
		return ResponseDTO.builder().message(Constants.RETRIEVED).data(this.schoolRepository.findAll()).statusCode(200).build();
	}

	public ResponseDTO deleteSchool(Long school) {
		schoolRepository.deleteById(school);
     	return ResponseDTO.builder().message(Constants.REMOVED).statusCode(200).build();
		
	}
	

}
