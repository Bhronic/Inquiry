package com.inquiry.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inquiry.dao.StudentDao;
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

}
