package com.school.schoolmanagement.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.schoolmanagement.entity.Answer;
import com.school.schoolmanagement.repository.AnswerRepository;

@Service
public class AnswerService {
	
	@Autowired
	private AnswerRepository answerRepository;

	public List<Answer> displayAnswers(Long studentId) {
		// TODO Auto-generated method stub
		return answerRepository.findByStudentId(studentId);
	}


}
