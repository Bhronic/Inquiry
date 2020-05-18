package com.inquiry.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inquiry.dao.StudentDao;
import com.inquiry.model.Fees;
import com.inquiry.model.Inquiry;
import com.inquiry.model.Student;
import com.inquiry.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentDao studentDao;

	@Override
	public Student addStudent(Student student) {
		return studentDao.addStudent(student);
	}

	@Override
	public List<Student> viewAllStudent() {
		return studentDao.viewAllStudent();
	}

	@Override
	public List<Student> viewDeletedStudent(int del) {
		return studentDao.viewDeletedStudent(del);
	}

	@Override
	public List<Student> viewPendingStudent(int del) {
		return studentDao.viewPendingStudent(del);
	}

	@Override
	public Student findById(int id) {
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
	public List<Fees> findFeesHistoryById(int id) {
		return studentDao.findFeesHistoryById(id);
	}

}
