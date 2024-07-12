package com.school.schoolmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.schoolmanagement.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{



	

}
