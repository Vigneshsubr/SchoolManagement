package com.school.schoolmanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.schoolmanagement.entity.School;
import com.school.schoolmanagement.entity.Student;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long>{

	boolean existsByEmail(String email);

	Optional<Student> findByEmail(String email);

	

	

	

}
