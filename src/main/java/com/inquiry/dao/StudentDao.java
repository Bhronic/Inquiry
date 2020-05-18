package com.inquiry.dao;

import java.util.List;

import com.inquiry.model.Fees;
import com.inquiry.model.Inquiry;
import com.inquiry.model.Student;

public interface StudentDao {
	
	public Student addStudent(Student student);
	
	public List<Student> viewAllStudent();
	
	public List<Student> viewDeletedStudent(int del);
	
	public List<Student> viewPendingStudent(int del);
	
	public Student findById(int id);
	
	public Inquiry findInquiryById(int id);
	
	public void deleteInquiryById(int id);
	
	public List<Fees> findFeesHistoryById(int id);

}
