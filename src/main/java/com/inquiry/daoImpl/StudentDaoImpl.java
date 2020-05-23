package com.inquiry.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inquiry.dao.StudentDao;
import com.inquiry.model.Inquiry;
import com.inquiry.model.StudentDetails;
import com.inquiry.repository.StudentRepository;

@Repository
public class StudentDaoImpl implements StudentDao {
	
	@Autowired
	StudentRepository studentRepository;

	@Override
	public StudentDetails addStudent(StudentDetails studentdtls) {
		return studentRepository.save(studentdtls);
	}

	@Override
	public List<StudentDetails> viewAllStudent() {
		return studentRepository.findAll();
	}

	@Override
	public List<StudentDetails> viewDeletedStudent(int del) {
		return studentRepository.findByDel(del);
	}

	@Override
	public List<StudentDetails> viewPendingStudent(int del) {
		return studentRepository.findByDel(del);
	}

	@Override
	public StudentDetails findById(int id) {
		return studentRepository.findByID(id);
	}

	@Override
	public Inquiry findInquiryById(int id) {
		return studentRepository.findInquiryByID(id);
	}

	@Override
	public void deleteInquiryById(int id) {
		studentRepository.deleleInquiryByID(id);
	}
	
	@Override
	public List<StudentDetails> findAllPaidOrPendingFees() {
		return studentRepository.findAll();
	}

}
