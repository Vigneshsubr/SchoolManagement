package com.school.schoolmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.schoolmanagement.entity.Result;

@Repository
public interface ResultRepository extends JpaRepository<Result, Object>{

}
