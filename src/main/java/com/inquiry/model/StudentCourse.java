package com.inquiry.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StudentCourse {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ID;
	
	private String course;
	
	private String batch_time;
	
	private Date joining_date;
	
	private Date completion_date;
	
	private Double fees;
	
	@Column(name = "teacher_appointed")
	private String teacher;
	
	private Double feesPaid;
	
	private Date last_fees_paid;
	
	@Column(columnDefinition = "int default 0")
	private int status;	//Current = 0, Completed = 1, Discontinued = 2
	
	@Column(columnDefinition = "int default 0")
	private int certificate; //Remaining = 0, Given = 1
	
	private int score;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getBatch_time() {
		return batch_time;
	}

	public void setBatch_time(String batch_time) {
		this.batch_time = batch_time;
	}

	public Date getJoining_date() {
		return joining_date;
	}

	public void setJoining_date(Date joining_date) {
		this.joining_date = joining_date;
	}

	public Date getCompletion_date() {
		return completion_date;
	}

	public void setCompletion_date(Date completion_date) {
		this.completion_date = completion_date;
	}

	public Double getFees() {
		return fees;
	}

	public void setFees(Double fees) {
		this.fees = fees;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public Double getFeesPaid() {
		return feesPaid;
	}

	public void setFeesPaid(Double feesPaid) {
		this.feesPaid = feesPaid;
	}

	public Date getLast_fees_paid() {
		return last_fees_paid;
	}

	public void setLast_fees_paid(Date last_fees_paid) {
		this.last_fees_paid = last_fees_paid;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getCertificate() {
		return certificate;
	}

	public void setCertificate(int certificate) {
		this.certificate = certificate;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
