package com.school.schoolmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.schoolmanagement.entity.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Long> {
	
	

}