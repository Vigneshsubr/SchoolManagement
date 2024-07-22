package com.school.schoolmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.schoolmanagement.dto.ResponseDTO;
import com.school.schoolmanagement.entity.Question;
import com.school.schoolmanagement.repository.QuestionRepository;
import com.school.schoolmanagement.util.Constants;

@Service
public class QuestionService {
	
	@Autowired
	QuestionRepository questionRepository;

	public ResponseDTO crateQuestions(Question question) {

		return ResponseDTO.builder().message(Constants.CREATED).data(questionRepository.save(question)).statusCode(200).build();
	}

	public ResponseDTO retriveQuestion() {

		return ResponseDTO.builder().message(Constants.RETRIEVED).data(questionRepository.findAll()).statusCode(200).build();
	}
	
	public ResponseDTO getQuestionById(Long id) {

		return ResponseDTO.builder().message(Constants.FOUND).data(questionRepository.findById(id)).statusCode(200).build();
	}
	
	

	public ResponseDTO getQuestionsByCategory(Long id) {

		return ResponseDTO.builder().message(Constants.FOUND).data(questionRepository.findBysubject_id(id)).statusCode(200).build();
	}



	public ResponseDTO deleteQuestion(Long id) {
		questionRepository.deleteById(id);
		return ResponseDTO.builder().message(Constants.REMOVED).statusCode(200).build();

	}

}
