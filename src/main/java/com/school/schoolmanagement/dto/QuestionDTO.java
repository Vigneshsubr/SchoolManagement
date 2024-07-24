package com.school.schoolmanagement.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class QuestionDTO {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String question;
	private String option1;
	private String option2;
	
	public QuestionDTO(long id, String question, String option1, String option2) {
		super();
		this.id = id;
		this.question = question;
		this.option1 = option1;
		this.option2 = option2;
	}



}
