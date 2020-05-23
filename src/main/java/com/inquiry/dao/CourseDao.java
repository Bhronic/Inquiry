package com.inquiry.dao;

import java.util.List;

import com.inquiry.model.Course;

public interface CourseDao {
	
	public List<Course> viewAllCourse();
	
	public Course addCourse(Course course);
	
	public Course findById(int id);
	
	public void deleteCourse(int id);

}
