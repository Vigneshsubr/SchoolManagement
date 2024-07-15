package com.school.schoolmanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;;

@Entity
@Table(name="tutor")

public class Tutor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String address;
	
	
	@ManyToOne
	private School school;
	
	@ManyToOne
	private Subject subject;
	
	
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public Subject getSubject() {
		return subject;
	}


	public void setSubject(Subject subject) {
		this.subject = subject;
	}


	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public School getSchool() {
		return school;
	}


	public void setSchool(School school) {
		this.school = school;
	}





}
