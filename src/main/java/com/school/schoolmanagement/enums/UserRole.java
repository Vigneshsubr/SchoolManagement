package com.school.schoolmanagement.enums;

public enum UserRole {
	
	ADMIN("admin"),
	STUDENT("student"),
	TUTOR("tutor");
	
	
	private String role;
	
	
	UserRole(String role){
		this.role=role;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
