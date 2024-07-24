package com.school.schoolmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.schoolmanagement.dto.ResponseDTO;
import com.school.schoolmanagement.entity.Tutor;
import com.school.schoolmanagement.repository.TutorRepository;
import com.school.schoolmanagement.util.Constants;

@Service
public class TutorService {
	@Autowired
	public TutorRepository tutorRepository;

	public ResponseDTO createTutor(Tutor tutor) {
		return ResponseDTO.builder().message(Constants.CREATED).data(tutorRepository.save(tutor)).statusCode(200).build();
		
	}
	
	

	public  ResponseDTO retriveTutor() {
		return ResponseDTO.builder().message(Constants.RETRIEVED).data(this.tutorRepository.findAll()).statusCode(200).build();
	}
	
	

	public  ResponseDTO tutordetials(Long id) {
		return ResponseDTO.builder().message(Constants.FOUND).data(tutorRepository.findById(id)).statusCode(200).build();
	}

}
