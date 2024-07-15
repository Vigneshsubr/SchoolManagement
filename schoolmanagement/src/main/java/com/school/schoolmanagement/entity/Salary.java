package com.school.schoolmanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="salary")
public class Salary {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Integer Salary;
	private String date;
	
	
	@ManyToOne
	private Tutor tutor;
	
	
	
	public Tutor getTutor() {
		return tutor;
	}
	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getSalary() {
		return Salary;
	}
	public void setSalary(Integer salary) {
		Salary = salary;
	}

}
