package com.inquiry.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class FacultyDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ID;
	
	private String faculty_name;
	
	private String mob_no;
	
	private String email;
	
	private Date dob;
	
	private String address;
	
	private String qualification;
	
	private double hourly_wage;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "teacher_id")
	private List<FacultyCourse> courseList;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getFaculty_name() {
		return faculty_name;
	}

	public void setFaculty_name(String faculty_name) {
		this.faculty_name = faculty_name;
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

	public double getHourly_wage() {
		return hourly_wage;
	}

	public void setHourly_wage(double hourly_wage) {
		this.hourly_wage = hourly_wage;
	}

	public List<FacultyCourse> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<FacultyCourse> courseList) {
		this.courseList = courseList;
	}

}
