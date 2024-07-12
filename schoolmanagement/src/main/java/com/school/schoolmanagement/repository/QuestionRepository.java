package com.school.schoolmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.school.schoolmanagement.entity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long>{
	
	List<Question> findBysubject_id(Long id);
	
	 @Query(value = "SELECT * FROM question q WHERE q.subject_id = :id ORDER BY RAND() LIMIT :numQ", nativeQuery = true)
	    List<Question> findRandomQuestionBysubject_id(@Param("id") Long id, @Param("numQ") int numQ);
	}
