package com.school.schoolmanagement.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class AuthConfig {
	
	@Autowired
	public SecurityFilter securityFilter;
	
	
	 @Bean
	    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
	        return httpSecurity
	            .csrf(csrf -> csrf.disable())
	            
	            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
	            
	            .authorizeHttpRequests(authorize -> authorize
	                .requestMatchers("/api/v1/auth/**").permitAll()
	                .requestMatchers("/api/v1/tutor/**").hasAnyAuthority("TUTOR", "ADMIN")
	                .requestMatchers("/api/v1/student/**").hasAnyAuthority("TUTOR", "ADMIN", "STUDENT")
	                .requestMatchers("/api/v1/question/**").hasAuthority("TUTOR")
	                .requestMatchers("/api/v1/admin/**").hasAnyAuthority("ADMIN")
	                .requestMatchers("/api/v1/quiz/show/{id}").hasAnyAuthority("STUDENT","TUTOR")
	                .requestMatchers("/api/v1/quiz/submit").hasAuthority("STUDENT")
	                .requestMatchers("api/v1/quiz/create","api/v1/quiz/delete/{id}","api/v1/quiz/result").hasAuthority("TUTOR")	
	                .requestMatchers("/api/v1/answers/display/{studentId}").hasAuthority("TUTOR")
	                .requestMatchers("/api/v1/result/display/{studentId}").hasAnyAuthority("STUDENT","TUTOR")
	                .requestMatchers("/api/v1/result/total/{studentId}").hasAnyAuthority("STUDENT","TUTOR")
	                .requestMatchers("/api/v1/result/delete/{id}").hasAnyAuthority("TUTOR","ADMIN")
	                .requestMatchers("/api/v1/school/**").hasAuthority("ADMIN")
	                .requestMatchers("/api/v1/salary/create","/api/v1/salary/modify/{id}").hasAuthority("ADMIN")
	                .requestMatchers("/api/v1/salary/findsalary/{id}").hasAnyAuthority("TUTOR","ADMIN")

	                .anyRequest().authenticated())
	            
	            .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
	            .build();
	    }

	    @Bean
	    AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
	        return config.getAuthenticationManager();
	    }

	    @Bean
	    PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	}