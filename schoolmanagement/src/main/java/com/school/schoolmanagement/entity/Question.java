package com.school.schoolmanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="question")
@Data
public class Question {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String question;
	private String option1;
	private String option2;
	private String rightAnswer;
	
	@ManyToOne
	private Tutor tutor;
	

	@ManyToOne
	private Subject subject;
	


	
	

}
