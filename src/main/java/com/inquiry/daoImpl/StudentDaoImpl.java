package com.inquiry.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inquiry.dao.StudentDao;
import com.inquiry.model.Fees;
import com.inquiry.model.Inquiry;
import com.inquiry.model.Student;
import com.inquiry.repository.StudentRepository;

@Repository
public class StudentDaoImpl implements StudentDao {
	
	@Autowired
	StudentRepository studentRepository;

	@Override
	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public List<Student> viewAllStudent() {
		return studentRepository.findAll();
	}

	@Override
	public List<Student> viewDeletedStudent(int del) {
		return studentRepository.findByDel(1);
	}

	@Override
	public List<Student> viewPendingStudent(int del) {
		return studentRepository.findByDel(0);
	}

	@Override
	public Student findById(int id) {
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
	public List<Fees> findFeesHistoryById(int id) {
		return studentRepository.findFeesHistoryById(id);
	}

}
