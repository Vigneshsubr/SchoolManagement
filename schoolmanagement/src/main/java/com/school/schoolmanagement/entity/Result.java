package com.school.schoolmanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="result")
@Data
public class Result {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
    private int totalQuestions;
    private int correctAnswers;
    private int totalMarks;
    
    @ManyToOne
    private Quiz quiz;
    
    @ManyToOne
    private Student student;
    
}
