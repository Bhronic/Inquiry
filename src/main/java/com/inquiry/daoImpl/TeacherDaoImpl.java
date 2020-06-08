package com.inquiry.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inquiry.dao.TeacherDao;
import com.inquiry.model.TeacherDetails;
import com.inquiry.repository.TeacherRepository;

@Repository
public class TeacherDaoImpl implements TeacherDao {
	
	@Autowired
	TeacherRepository teacherRepository;

	@Override
	public TeacherDetails addTeacher(TeacherDetails teacher) {
		return teacherRepository.save(teacher);
	}

	@Override
	public List<TeacherDetails> findAll() {
		return teacherRepository.findAll();
	}

}
