package com.school.schoolmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.schoolmanagement.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

	boolean existsByEmail(String email);

	
	Admin findByEmail(String email);

	

	

}
