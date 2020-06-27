package com.inquiry.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.inquiry.dao.CourseDao;
import com.inquiry.model.Course;
import com.inquiry.repository.CourseRepository;

@Repository
public class CourseDaoImpl implements CourseDao {
	
	@Autowired
	CourseRepository courseRepository;

	@Override
	public List<Course> viewAllCourse() {
		return courseRepository.findAll();
	}

	@Override
	public Course addCourse(Course course) {
		Course c = new Course();
		try {
			c = courseRepository.save(course);
		}catch(Exception e) {
			c = null;
		}
		return c;
	}

	@Override
	public Course findById(int id) {
		return courseRepository.findByID(id);
	}

	@Override
	public void deleteCourse(int id) {
		courseRepository.deleteById(id);
	}

	@Override
	public List<Course> search(String search) {
		return courseRepository.search(search);
	}

	@Override
	public Page<Course> findPage(Pageable pageable) {
		return courseRepository.findAll(pageable);
	}

}
