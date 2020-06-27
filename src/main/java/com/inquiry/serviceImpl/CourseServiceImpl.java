package com.inquiry.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.inquiry.dao.CourseDao;
import com.inquiry.model.Course;
import com.inquiry.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	CourseDao courseDao;

	@Override
	public List<Course> viewAllCourse() {
		return courseDao.viewAllCourse();
	}

	@Override
	public Course addCourse(Course course) {
		return courseDao.addCourse(course);
	}

	@Override
	public Course findById(int id) {
		return courseDao.findById(id);
	}

	@Override
	public void deleteCourse(int id) {
		courseDao.deleteCourse(id);
	}

	@Override
	public List<Course> search(String search) {
		return courseDao.search(search);
	}

	@Override
	public Page<Course> findPage(Pageable pageable) {
		return courseDao.findPage(pageable);
	}

}
