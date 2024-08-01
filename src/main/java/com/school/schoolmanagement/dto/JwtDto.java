package com.school.schoolmanagement.dto;

public class JwtDto {
	
	String accessToken;
    String refreshToken;
    
    
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	public JwtDto(String accessToken, String refreshToken) {
	
		this.accessToken = accessToken;
		this.refreshToken = refreshToken;
	}
	public JwtDto() {
		// TODO Auto-generated constructor stub
	}

}
