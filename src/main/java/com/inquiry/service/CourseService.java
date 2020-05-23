package com.inquiry.service;

import java.util.List;

import com.inquiry.model.Course;

public interface CourseService {
	
	public List<Course> viewAllCourse();
	
	public Course addCourse(Course course);
	
	public Course findById(int id);
	
	public void deleteCourse(int id);

}
