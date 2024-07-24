package com.school.schoolmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.schoolmanagement.dto.ResponseDTO;
import com.school.schoolmanagement.repository.AnswerRepository;
import com.school.schoolmanagement.util.Constants;

@Service
public class AnswerService {
	
	@Autowired
	private AnswerRepository answerRepository;

	public ResponseDTO displayAnswers(Long studentId) {
		
		return ResponseDTO.builder()
				.message(Constants.RETRIEVED)
				.data(answerRepository.findByStudentId(studentId))
				.statusCode(200)
				.build();
	}


}
