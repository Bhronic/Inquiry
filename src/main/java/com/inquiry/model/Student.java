package com.inquiry.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ID;
	
	private String student_name;
	
	private String mob_no;
	
	private String email;
	
	private Date dob;
	
	private String address;
	
	private String qualification;
	
	private String course;
	
	private String batch_time;
	
	private Date joining_date;
	
	private Double fees;
	
	@Column(name = "teacher_appointed")
	private String teacher;
	
	private Double fees_paid;
	
	@Column(columnDefinition = "int default 0")
	private int del;
	
	private Date last_date;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public String getMob_no() {
		return mob_no;
	}

	public void setMob_no(String mob_no) {
		this.mob_no = mob_no;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
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

	public Double getFees_paid() {
		return fees_paid;
	}

	public void setFees_paid(Double fees_paid) {
		this.fees_paid = fees_paid;
	}

	public int getDelete() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}

	public Date getLast_date() {
		return last_date;
	}

	public void setLast_date(Date last_date) {
		this.last_date = last_date;
	}

}
