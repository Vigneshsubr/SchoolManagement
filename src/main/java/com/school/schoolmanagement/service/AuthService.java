package com.school.schoolmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.school.schoolmanagement.config.TokenProvider;
import com.school.schoolmanagement.dto.AdminDTO;
import com.school.schoolmanagement.dto.ResponseDTO;
import com.school.schoolmanagement.dto.StudentDTO;
import com.school.schoolmanagement.dto.TutorDTO;
import com.school.schoolmanagement.entity.Admin;
import com.school.schoolmanagement.entity.Student;
import com.school.schoolmanagement.entity.Tutor;
import com.school.schoolmanagement.enums.UserRole;
import com.school.schoolmanagement.exceptions.InvalidJwtException;
import com.school.schoolmanagement.repository.AdminRepository;
import com.school.schoolmanagement.repository.SchoolRepository;
import com.school.schoolmanagement.repository.StudentRepository;
import com.school.schoolmanagement.repository.SubjectRepository;
import com.school.schoolmanagement.repository.TutorRepository;
import com.school.schoolmanagement.util.Constants;

import jakarta.transaction.Transactional;




@Service
@Transactional
public class AuthService implements UserDetailsService {
	

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	SchoolRepository schoolRepository;
	
	@Autowired
	TutorRepository tutorRepository;
	
	@Autowired
	SubjectRepository subjectRepository;
	
	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	TokenProvider tokenProvider;
	
	UserRole role;


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
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
	

	 public ResponseDTO signUpStudent(StudentDTO studentDTO) throws InvalidJwtException{
		 
		 if (!tokenProvider.emailValidation(studentDTO.getEmail())) {
	            throw new InvalidJwtException("Email is not in the correct format");
	        }
	        if (!tokenProvider.passwordValidation(studentDTO.getPassword())) {
	            throw new InvalidJwtException("Password is not valid");
	        }
		 
		 if (adminRepository.existsByEmail(studentDTO.getEmail()) || tutorRepository.existsByEmail(studentDTO.getEmail()) || studentRepository.existsByEmail(studentDTO.getEmail())) {
	            throw new InvalidJwtException("This student Email already exists");
	        }
		 
	        String encryptedPassword = new BCryptPasswordEncoder().encode(studentDTO.getPassword());
	        Student user=new Student();
			 user.setEmail(studentDTO.getEmail());
			 user.setPassword(encryptedPassword);
			 user.setRole(UserRole.STUDENT);
			 user.setAddress(studentDTO.getAddress());
			 user.setName(studentDTO.getName());
			 user.setSchool(schoolRepository.findById(studentDTO.getSchoolId()).orElseThrow(null));
			 
			 
			 return ResponseDTO.builder()
					 .message(Constants.CREATED)
					 .data(studentRepository.save(user))
					 .statusCode(200)
					 .build();       
	       
	    }
	 
	 
	 public ResponseDTO signUpTutor(TutorDTO tutorDTO) throws InvalidJwtException{
		 
		 if (!tokenProvider.emailValidation(tutorDTO.getEmail())) {
	            throw new InvalidJwtException("Email is not in the correct format");
	        }
	        if (!tokenProvider.passwordValidation(tutorDTO.getPassword())) {
	            throw new InvalidJwtException("Password is not valid");
	        }
		 
		 if (adminRepository.existsByEmail(tutorDTO.getEmail()) || tutorRepository.existsByEmail(tutorDTO.getEmail()) || studentRepository.existsByEmail(tutorDTO.getEmail())) {
	            throw new InvalidJwtException("This tutor Email already exists");
	        }
		 
	        String encryptedPassword = new BCryptPasswordEncoder().encode(tutorDTO.getPassword());
	        Tutor tutor=new Tutor();
	        tutor.setEmail(tutorDTO.getEmail());
	        tutor.setPassword(encryptedPassword);
	        tutor.setRole(UserRole .TUTOR);
	        tutor.setAddress(tutorDTO.getAddress());
	        tutor.setName(tutorDTO.getName());
	        
			tutor.setSubject(subjectRepository.findById(tutorDTO.getSubject()).orElse(null));
			 tutor.setSchool(schoolRepository.findById(tutorDTO.getSchoolId()).orElseThrow(null));
			 
			 
			 return ResponseDTO.builder()
					 .message(Constants.CREATED)
					 .data(tutorRepository.save(tutor))
					 .statusCode(200)
					 .build();       
	       
	    }
	 
	 

	public ResponseDTO signUpAdmin(AdminDTO adminDTO) throws InvalidJwtException {
	
//		 if(adminRepository.findByEmail(adminDTO.getEmail())!=null) {
//				throw new InvalidJwtException("Admin all ready exists");
//				
//			}
		
		if (!tokenProvider.emailValidation(adminDTO.getEmail())) {
            throw new InvalidJwtException("Email is not in the correct format");
        }
        if (!tokenProvider.passwordValidation(adminDTO.getPassword())) {
            throw new InvalidJwtException("Password is not valid");
        }
		
		
		if (adminRepository.existsByEmail(adminDTO.getEmail()) || tutorRepository.existsByEmail(adminDTO.getEmail()) || studentRepository.existsByEmail(adminDTO.getEmail())) {
            throw new InvalidJwtException("This admin Email already exists");
        }
	        String encryptedPassword = new BCryptPasswordEncoder().encode(adminDTO.getPassword());
	        Admin admin=new Admin();
	        admin.setEmail(adminDTO.getEmail());
	        admin.setPassword(encryptedPassword);
	        admin.setRole(UserRole .ADMIN);
	        admin.setName(adminDTO.getName());
	        

			 
			 return ResponseDTO.builder()
					 .message(Constants.CREATED)
					 .data(adminRepository.save(admin))
					 .statusCode(200)
					 .build();       
	}


	


}
