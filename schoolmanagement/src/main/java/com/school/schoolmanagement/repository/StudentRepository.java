package com.school.schoolmanagement.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.school.schoolmanagement.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

	
	

//	
//	@Query(value="SELECT * FROM STUDENT_DETIALS s "
//			+"WHERE (:name IS NULL OR s.name LIKE %:name%)"
//			+"AND (:address IS NULL OR s.address LIKE %:address%)"
//			+"AND (:schoolId IS NULL OR s.school_id  LIKE %:schoolId%)"
//			,nativeQuery=true)
//	
//	List<Student> searchStudent(@Param("name") String name,@Param("schoolId") Long schoolId,@Param("address") String address);

	
	
	
	@Query(value = "SELECT * FROM STUDENT_DETIALS s WHERE (:name IS NULL OR s.name LIKE %:name%)", nativeQuery = true)
	List<Student> findStudentByName(@Param("name") String name);


	@Query(value="SELECT * FROM Student_detials s WHERE (:address IS NULL OR s.address LIKE %:address%)",nativeQuery=true)
	List<Student> findStudentByAddress(@Param("address") String address);


	@Query(value="SELECT * FROM STUDENT_DETIALS s"
			+"WHERE (:search IS NULL OR s.name LIKE %:search%)"
			+"AND (:search IS NULL OR s.address LIKE %:search%)"
			+"AND (:search IS NULL OR s.school_id LIKE %:search%)"
			,nativeQuery=true)
	Page<Student> findByNameContaining(String search, Pageable pageable);

	





	

}
