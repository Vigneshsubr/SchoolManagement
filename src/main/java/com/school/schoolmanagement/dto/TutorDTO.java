package com.school.schoolmanagement.dto;

import lombok.Builder;

@Builder
public class TutorDTO {
	
	public String email;
	public String password;
	public Long subject;
	public Long schoolId;
	public String address;
	public String name;
	
	
	public Long getSubject() {
		return subject;
	}
	public void setSubject(Long subject) {
		this.subject = subject;
	}
	public Long getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(Long schoolId) {
		this.schoolId = schoolId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
