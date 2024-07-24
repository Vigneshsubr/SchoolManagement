package com.school.schoolmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.school.schoolmanagement.entity.Question;
import com.school.schoolmanagement.entity.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz,Long>{
	
	
	@Query(value="SELECT * FROM question q Where q.id=:id ORDER BY RAND() LIMIT:numQ",nativeQuery=true)
	
	List<Question> findRandomQuestionsBySubject_id(Long id,int numQ);

}
