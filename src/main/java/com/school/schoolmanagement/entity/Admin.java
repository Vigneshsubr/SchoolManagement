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
import lombok.Data;

@Entity
@Data
public class Admin implements UserDetails{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String password;
	
	 @Column(unique = true, updatable = false, nullable = false)
	private String email;
	
	@Enumerated(EnumType.STRING)
	private UserRole role;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		

		return List.of(new SimpleGrantedAuthority("ADMIN"), new SimpleGrantedAuthority("TUTOR"),new SimpleGrantedAuthority("STUDENT"));
	}
	
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}
	
	 @Override
	  public boolean isAccountNonExpired() {
	    return true;
	  }

	  @Override
	  public boolean isAccountNonLocked() {
	    return true;
	  }

	  @Override
	  public boolean isCredentialsNonExpired() {
	    return true;
	  }

	  @Override
	  public boolean isEnabled() {
	    return true;
	  }
	
	

}
