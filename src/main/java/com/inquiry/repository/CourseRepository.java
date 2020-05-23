package com.inquiry.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inquiry.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
	
	public Course findByID(int id);

}
