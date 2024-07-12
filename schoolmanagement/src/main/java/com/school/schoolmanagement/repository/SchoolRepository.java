package com.school.schoolmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.schoolmanagement.entity.School;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long>{

	

}
