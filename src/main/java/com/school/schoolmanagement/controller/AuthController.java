package com.school.schoolmanagement.controller;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.school.schoolmanagement.config.TokenProvider;
import com.school.schoolmanagement.dto.AdminDTO;
import com.school.schoolmanagement.dto.JwtDto;
import com.school.schoolmanagement.dto.RefreshTokenDTO;
import com.school.schoolmanagement.dto.ResponseDTO;
import com.school.schoolmanagement.dto.SignInDto;
import com.school.schoolmanagement.dto.StudentDTO;
import com.school.schoolmanagement.dto.TutorDTO;
import com.school.schoolmanagement.entity.Admin;
import com.school.schoolmanagement.entity.Student;
import com.school.schoolmanagement.entity.Tutor;
import com.school.schoolmanagement.exceptions.CustomException;
import com.school.schoolmanagement.exceptions.InvalidJwtException;
import com.school.schoolmanagement.repository.AdminRepository;
import com.school.schoolmanagement.repository.StudentRepository;
import com.school.schoolmanagement.repository.TutorRepository;
import com.school.schoolmanagement.service.AuthService;
import com.school.schoolmanagement.util.Constants;



@RestController
@RequestMapping("api/v1/auth")
public class AuthController {
	
	@Autowired
	AuthService authService;
	
	@Autowired
	TokenProvider tokenProvider;
	
	Constants constants;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	TutorRepository tutorRepository;
	
	
	@PostMapping("/sign-up/student")
    public ResponseDTO signUpStudent(@RequestBody StudentDTO studentDTO) throws InvalidJwtException {
       
        return authService.signUpStudent(studentDTO);
    } 
	
	@PostMapping("/sign-up/tutor")
    public ResponseDTO signUpTutor(@RequestBody TutorDTO tutorDTO) throws InvalidJwtException {
       
        return authService.signUpTutor(tutorDTO);
    } 
	
	
	@PostMapping("sign-up/admin")
	public ResponseDTO signUpAdmin(@RequestBody AdminDTO adminDTO)throws InvalidJwtException{
		return authService.signUpAdmin(adminDTO);
	}
	
	@PostMapping("/sign-in")
	public ResponseDTO signIn(@RequestBody SignInDto user) throws AuthenticationException,CustomException {
		

	    // var userNamePassword = new UsernamePasswordAuthenticationToken((tokenProvider.emailValidation(user.getEmail())),tokenProvider.passwordValidation(user.getPassword()));
	    // var userNamePassword = new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword());
				
		
		try {
			
		if (!tokenProvider.emailValidation(user.getEmail())) {
            throw new CustomException("Email is not in the correct format");
        }
        if (!tokenProvider.passwordValidation(user.getPassword())) {
            throw new CustomException("Password is not valid");
        }
        
        
        
		 
        var userNamePassword = new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword());
	    var authorizedUser = authenticationManager.authenticate(userNamePassword);
	    var principal = authorizedUser.getPrincipal();
	    String accessToken;
	    String refreshToken;

	    if (principal instanceof Student) {
	        accessToken = tokenProvider.generateAccessToken((Student) principal);
	        refreshToken = tokenProvider.generateRefreshToken((Student) principal);
	    } else if (principal instanceof Tutor) {
	        accessToken = tokenProvider.generateAccessToken((Tutor) principal);
	        refreshToken = tokenProvider.generateRefreshToken((Tutor) principal);
	    } else if (principal instanceof Admin) {
	        accessToken = tokenProvider.generateAccessToken((Admin) principal);
	        refreshToken = tokenProvider.generateRefreshToken((Admin) principal);
	    } else {
	        // handle default case or throw an exception
	        accessToken = tokenProvider.generateAccessToken((UserDetails) principal);
	        refreshToken = tokenProvider.generateRefreshToken((UserDetails) principal);
	    }

	    ResponseDTO responseDto = new ResponseDTO();
	    responseDto.setMessage(Constants.RETRIEVED);
	    responseDto.setData(new JwtDto(accessToken,refreshToken));
	    responseDto.setStatusCode(200);
	    return responseDto;
		}
		catch(Exception e) {
			 ResponseDTO responseDto = new ResponseDTO();
	            responseDto.setMessage("Invalid refresh token");
	            responseDto.setStatusCode(401);
	            return responseDto;
		}
	}

	
	
	@PostMapping("/refresh-token")
	public ResponseEntity<ResponseDTO> refreshToken(@RequestBody RefreshTokenDTO refreshTokenDTO) {
		try {
			String refreshToken = refreshTokenDTO.getRefreshToken();
			String newAccessToken = tokenProvider.refreshAccessToken(refreshToken);
			String newRefreshToken = tokenProvider.refreshRefreshToken(refreshToken);

			JwtDto jwtDto = new JwtDto(newAccessToken, newRefreshToken);
			ResponseDTO responseDto = new ResponseDTO();
			responseDto.setMessage(Constants.RETRIEVED);
			responseDto.setData(jwtDto);
			responseDto.setStatusCode(200);

			return ResponseEntity.ok(responseDto);
		} catch (JWTVerificationException e) {
			ResponseDTO responseDto = new ResponseDTO();
			responseDto.setMessage("Invalid refresh token");
			responseDto.setStatusCode(401);
			return ResponseEntity.status(401).body(responseDto);
		}
	}
	
	
	
	
	
	
	
	
	

}
