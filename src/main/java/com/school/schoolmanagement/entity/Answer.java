package com.school.schoolmanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "answer")
@Data
public class Answer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String selectedAnswer;

	@ManyToOne
	private Student student;

	@ManyToOne
	private Question question;

	@ManyToOne
	private Quiz quiz;

}
