package com.inquiry.service;

import java.util.List;

import com.inquiry.model.Fees;
import com.inquiry.model.Student;

public interface FeesService {
	
	public Fees payFees(Fees fees);

	public List<Student> findAllPaidFees();

	public List<Student> findAllPendingFees();

	public Student findStudentById(int id);

	public void saveStudent(int id, double feesPaid);

	public int countPendingFees();

}
