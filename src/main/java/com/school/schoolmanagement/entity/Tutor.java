package com.school.schoolmanagement.entity;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.school.schoolmanagement.enums.UserRole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;;

@Entity
@Table(name="tutor")
@Data

public class Tutor implements UserDetails {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@Column(unique = true, updatable = false, nullable = false)
	private String email;
	private String address;
	private String password;
	
	
	@Enumerated(EnumType.STRING)
	  @Column(length = 50)
	private UserRole role;
	
	
	@ManyToOne
	private School school;
	
	@ManyToOne
	private Subject subject;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		if (this.role == UserRole.TUTOR) {
		      return List.of(new SimpleGrantedAuthority("TUTOR"), new SimpleGrantedAuthority("STUDENT"));
		    }
		    return List.of(new SimpleGrantedAuthority("STUDENT"));
		  }
	

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}

	
	    

}
