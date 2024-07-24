package com.school.schoolmanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.school.schoolmanagement.entity.Result;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long>{

	Optional<Result> findByStudentId(Long studentId);

	
	@Query(value="SELECT SUM(total_marks) FROM result Where Student_id=?1",nativeQuery=true)
	Integer calculateTotalByStudentId(Long studentId);

}
