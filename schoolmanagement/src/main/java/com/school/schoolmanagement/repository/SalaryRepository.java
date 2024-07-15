package com.school.schoolmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.schoolmanagement.entity.Salary;


@Repository
public interface SalaryRepository extends JpaRepository<Salary,Long>{
	

}
