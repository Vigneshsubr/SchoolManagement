package com.school.schoolmanagement.config;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.school.schoolmanagement.entity.Admin;
import com.school.schoolmanagement.entity.Student;
import com.school.schoolmanagement.entity.Tutor;
import com.school.schoolmanagement.repository.AdminRepository;
import com.school.schoolmanagement.repository.StudentRepository;
import com.school.schoolmanagement.repository.TutorRepository;

@Service
public class TokenProvider {

	@Autowired
	StudentRepository studentRepository;
	@Autowired
	TutorRepository tutorRepository;
	@Autowired
	AdminRepository adminRepository;

	@Value("{security.jwt.secret-key}")
	String secretKey;

	public String generateAccessToken(UserDetails user) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(secretKey);
			return JWT.create().withSubject(user.getUsername()).withClaim("UserEmail", user.getUsername())
					.withExpiresAt(genAccessExperationDate()).sign(algorithm);
		} catch (JWTCreationException exception) {
			throw new JWTCreationException("Error while generating access token", exception);
		}
	}

	public String validateToken(String token) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(secretKey);
			return JWT.require(algorithm).build().verify(token).getSubject();
		} catch (JWTVerificationException excepiton) {
			throw new JWTVerificationException("Error while validating access token", excepiton);
		}

	}

	public String generateRefreshToken(UserDetails user) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(secretKey);
			return JWT.create().withSubject(user.getUsername()).withClaim("UserEmail", user.getUsername())
					.withExpiresAt(genRefreshExperationDate()).sign(algorithm);
		} catch (JWTCreationException exception) {
			throw new JWTCreationException("Error while generating refresh token", exception);
		}
	}

	public String validateRefreshToken(String token) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(secretKey);
			return JWT.require(algorithm).build().verify(token).getSubject();
		} catch (JWTVerificationException exception) {
			throw new JWTVerificationException("Error while validating refresh token", exception);
		}
	}
	
	

	public Instant genAccessExperationDate() {
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.UTC);

	}
	
	

	public Instant genRefreshExperationDate() {
		return LocalDateTime.now().plusDays(7).toInstant(ZoneOffset.UTC);

	}
	
	

	public String refreshAccessToken(String refreshToken) {
		String username = validateRefreshToken(refreshToken);
		UserDetails user = loadUserByUsername(username);
		return generateAccessToken(user);
	}
	
	

	public String refreshRefreshToken(String refreshToken) {
		String username = validateRefreshToken(refreshToken);
		UserDetails user = loadUserByUsername(username);
		return generateRefreshToken(user);
	}
	
	

	private UserDetails loadUserByUsername(String username) {
		Student student = studentRepository.findByEmail(username);
		if (student != null) {
			return student;
		}
		Tutor tutor = tutorRepository.findByEmail(username);
		if (tutor != null) {
			return tutor;
		}
		Admin admin = adminRepository.findByEmail(username);
		if (admin != null) {
			return admin;
		}
		throw new UsernameNotFoundException("User not found with email: " + username);
	}
	
	

	public boolean emailValidation(String email) {
		return Pattern.compile("^[a-z0-9+_.-]+@(gmail|yahoo|outlook|zoho)\\.com$").matcher(email).matches();
	}

	public boolean passwordValidation(String password) {
		String pass = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,20}$";
		return Pattern.compile(pass).matcher(password).matches();
	}

}
