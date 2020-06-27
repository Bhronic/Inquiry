package com.inquiry.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inquiry.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
	
	public Course findByID(int id);
	
	@Query("SELECT c FROM Course c WHERE c.course_name LIKE :search% OR c.course_id LIKE :search%")
	public List<Course> search(@Param("search") String search);

}
