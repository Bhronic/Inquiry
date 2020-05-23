package com.inquiry.service;

import java.util.List;

import com.inquiry.model.Inquiry;
import com.inquiry.model.StudentDetails;

public interface StudentService {
	
	public StudentDetails addStudent(StudentDetails studentdtls);
	
	public List<StudentDetails> viewAllStudent();
	
	public List<StudentDetails> viewDeletedStudent(int del);
	
	public List<StudentDetails> viewPendingStudent(int del);

	public StudentDetails findById(int id);

	public Inquiry findInquiryById(int id);

	public void deleteInquiryById(int id);
	
	public List<StudentDetails> findAllPaidOrPendingFees();

	
}
