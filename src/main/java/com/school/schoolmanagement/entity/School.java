package com.school.schoolmanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="school_detials")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class School {
	


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String address;
	private String email;
	
	
//	public School(Long schoolId) {
//		this.id=this.id;
//	}
	
}
