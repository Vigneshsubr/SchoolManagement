package com.school.schoolmanagement.dto;



import com.school.schoolmanagement.enums.UserRole;

import lombok.AllArgsConstructor;
import lombok.Builder;


@Builder
@AllArgsConstructor
public class StudentDTO {

	private String name;
	private String address;
	private Long schoolId;
	private String email;
	private String password;
	public UserRole role;

	
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


	public String getName() {
		return name;
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

	public Long getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Long schoolId) {
		this.schoolId = schoolId;
	}

	

	public StudentDTO() {
		// TODO Auto-generated constructor stub
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}




}
