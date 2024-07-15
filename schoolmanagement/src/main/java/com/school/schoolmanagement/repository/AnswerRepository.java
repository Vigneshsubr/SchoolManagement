package com.school.schoolmanagement.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.schoolmanagement.entity.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
	List<Answer> findByStudentIdAndQuizId(Long studentId, Long quizId);

	List<Answer> findByStudentId(Long studentId);

}
