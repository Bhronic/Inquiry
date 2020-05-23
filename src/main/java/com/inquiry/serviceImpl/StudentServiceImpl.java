package com.inquiry.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inquiry.dao.StudentDao;
import com.inquiry.model.Inquiry;
import com.inquiry.model.StudentDetails;
import com.inquiry.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentDao studentDao;

	@Override
	public StudentDetails addStudent(StudentDetails studentdtls) {
		return studentDao.addStudent(studentdtls);
	}

	@Override
	public List<StudentDetails> viewAllStudent() {
		return studentDao.viewAllStudent();
	}

	@Override
	public List<StudentDetails> viewDeletedStudent(int del) {
		return studentDao.viewDeletedStudent(del);
	}

	@Override
	public List<StudentDetails> viewPendingStudent(int del) {
		return studentDao.viewPendingStudent(del);
	}

	@Override
	public StudentDetails findById(int id) {
		return studentDao.findById(id);
	}

	@Override
	public Inquiry findInquiryById(int id) {
		return studentDao.findInquiryById(id);
	}

	@Override
	public void deleteInquiryById(int id) {
		studentDao.deleteInquiryById(id);
	}

	@Override
	public List<StudentDetails> findAllPaidOrPendingFees() {
		return studentDao.findAllPaidOrPendingFees();
	}

}
