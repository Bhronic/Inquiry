package com.inquiry.dao;

import java.util.List;

import com.inquiry.model.TeacherDetails;

public interface TeacherDao {
	
	public TeacherDetails addTeacher(TeacherDetails teacher);
	
	public List<TeacherDetails> findAll();

}
