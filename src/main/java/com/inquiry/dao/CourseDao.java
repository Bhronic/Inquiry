package com.inquiry.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.inquiry.model.Course;

public interface CourseDao {
	
	public List<Course> viewAllCourse();
	
	public Course addCourse(Course course);
	
	public Course findById(int id);
	
	public void deleteCourse(int id);
	
	public List<Course> search(String search);
	
	public Page<Course> findPage(Pageable pageable);

}
