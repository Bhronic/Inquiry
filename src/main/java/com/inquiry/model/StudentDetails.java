package com.inquiry.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class StudentDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ID;
	
	private String student_name;
	
	private String mob_no;
	
	private String email;
	
	private Date dob;
	
	private String address;
	
	private String qualification;
	
	@Column(columnDefinition = "int default 1")
	private int total_course;
	
	@Column(columnDefinition = "int default 0")
	private int course_completed;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "student_id")
	private List<StudentCourse> studentCourse;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "student_id")
	private List<Fees> feesTable;
	
	@Column(columnDefinition = "int default 0")
	private int del;

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

	public int getTotal_course() {
		return total_course;
	}

	public void setTotal_course(int total_course) {
		this.total_course = total_course;
	}

	public int getCourse_completed() {
		return course_completed;
	}

	public void setCourse_completed(int course_completed) {
		this.course_completed = course_completed;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}

	public List<StudentCourse> getStudentCourse() {
		return studentCourse;
	}

	public void setStudentCourse(List<StudentCourse> studentCourse) {
		this.studentCourse = studentCourse;
	}

	public List<Fees> getFeesTable() {
		return feesTable;
	}

	public void setFeesTable(List<Fees> feesTable) {
		this.feesTable = feesTable;
	}

}
