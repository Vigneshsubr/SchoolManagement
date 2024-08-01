package com.school.schoolmanagement.dto;

import com.school.schoolmanagement.enums.UserRole;

import lombok.Data;


@Data
public class SignUpDto {
	
	private String email;
	private String password;
	private UserRole role;

}
