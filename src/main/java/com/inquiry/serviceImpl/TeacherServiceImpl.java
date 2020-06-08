package com.inquiry.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inquiry.dao.TeacherDao;
import com.inquiry.model.TeacherDetails;
import com.inquiry.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {
	
	@Autowired
	TeacherDao teacherDao;

	@Override
	public TeacherDetails addTeacher(TeacherDetails teacher) {
		return teacherDao.addTeacher(teacher);
	}

	@Override
	public List<TeacherDetails> findAll() {
		return teacherDao.findAll();
	}

}
