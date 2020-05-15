package com.inquiry.dao;

import java.util.List;

import com.inquiry.model.Student;

public interface StudentDao {
	
	public Student addStudent(Student student);
	
	public List<Student> viewAllStudent();
	
	public List<Student> viewDeletedStudent(int del);
	
	public List<Student> viewPendingStudent(int del);

}
