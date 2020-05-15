package com.inquiry.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inquiry.dao.StudentDao;
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

}
