package com.school.schoolmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.schoolmanagement.entity.Tutor;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, Long>{

}
