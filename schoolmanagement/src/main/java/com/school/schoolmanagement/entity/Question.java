package com.school.schoolmanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="question")
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
	


	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getQuestion() {
		return question;
	}



	public void setQuestion(String question) {
		this.question = question;
	}



	public String getOption1() {
		return option1;
	}



	public void setOption1(String option1) {
		this.option1 = option1;
	}



	public String getOption2() {
		return option2;
	}



	public void setOption2(String option2) {
		this.option2 = option2;
	}



	public String getRightAnswer() {
		return rightAnswer;
	}



	public void setRightAnswer(String rightAnswer) {
		this.rightAnswer = rightAnswer;
	}



	public Subject getSubject() {
		return subject;
	}



	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	

}
