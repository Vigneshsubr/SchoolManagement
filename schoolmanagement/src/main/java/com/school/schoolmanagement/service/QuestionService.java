package com.school.schoolmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.schoolmanagement.entity.Question;
import com.school.schoolmanagement.repository.QuestionRepository;

@Service
public class QuestionService {
	
	@Autowired
	QuestionRepository repo;

	public Question crateQuestions(Question question) {
		// TODO Auto-generated method stub
		return repo.save(question);
	}

	public List<Question> retriveQuestion() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	
	

	public List<Question> getQuestionsByCategory(Long id) {
		// TODO Auto-generated method stub
		return repo.findBysubject_id(id);
	}

	public Optional<Question> getQuestionById(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	public void deleteQuestion(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		
	}

}
