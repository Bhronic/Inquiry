package com.inquiry.service;

import java.util.List;

import com.inquiry.model.TeacherDetails;

public interface TeacherService {
	
	public TeacherDetails addTeacher(TeacherDetails teacher);
	
	public List<TeacherDetails> findAll();

}
