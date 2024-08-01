package com.school.schoolmanagement.config;

import java.io.IOException;
//import java.util.Optional;

//import javax.lang.model.type.ErrorType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.school.schoolmanagement.repository.AdminRepository;
import com.school.schoolmanagement.repository.SchoolRepository;
import com.school.schoolmanagement.repository.StudentRepository;
import com.school.schoolmanagement.repository.TutorRepository;
import com.school.schoolmanagement.service.AuthService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {

	@Autowired
	TokenProvider tokenProvider;
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	TutorRepository tutorRepository;
	@Autowired
	AdminRepository adminRepository;
	@Autowired
	SchoolRepository schoolRepository;
	@Autowired
	AuthService authService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		var token = this.recoverToken(request);
		if (token != null) {

			String email = tokenProvider.validateToken(token);
			UserDetails user = authService.loadUserByUsername(email);

			var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(authentication);
		}
		filterChain.doFilter(request, response);

	}

	public String recoverToken(HttpServletRequest request) {
		var authHeader = request.getHeader("Authorization");
		if (authHeader == null) {
			return null;
		}
		return authHeader.replace("Bearer ", "");

	}

//	public Object findUserByEmail(String email) {
//        if (studentRepository.existsByEmail(email)) {
//            return studentRepository.findByEmail(email).orElseThrow(() -> new CustomException("Invalid email"));
//        } else if (tutorRepository.existsByEmail(email)) {
//            return tutorRepository.findByEmail(email).orElseThrow(() -> new CustomException("Invalid email"));
//        } else if (adminRepository.existsByEmail(email)) {
//            return adminRepository.findByEmail(email).orElseThrow(() -> new CustomException("Invalid email"));
//        } else if (schoolRepository.existsByEmail(email)) {
//            return schoolRepository.findByEmail(email).orElseThrow(() -> new CustomException("Invalid email"));
//        } else {
//            throw new CustomException("Invalid email");
//        }
//    }

}
