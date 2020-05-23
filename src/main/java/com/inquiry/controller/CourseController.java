package com.inquiry.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.inquiry.model.Course;
import com.inquiry.service.CourseService;

@Controller
public class CourseController {
	
	@Autowired
	CourseService courseService;
	
	@RequestMapping("ViewCourse")
	public ModelAndView viewCourse(HttpServletRequest request)
	{
		List<Course> viewCourseList = courseService.viewAllCourse();
		request.setAttribute("viewCourseList", viewCourseList);
		return new ModelAndView("ViewCourse");
	}
	
	@PostMapping("AddCourseController")
	public void addCourse(HttpServletRequest request, HttpServletResponse response)
	{
		Course course = new Course();
		course.setCourse_id(Integer.parseInt(request.getParameter("courseID")));
		course.setCourse_name(request.getParameter("courseName"));
		
		courseService.addCourse(course);
		
		try {
			response.sendRedirect("ViewCourse");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("EditCourse")
	public ModelAndView editCourse(HttpServletRequest request)
	{
		Course course = courseService.findById(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("course", course);
		return new ModelAndView("EditCourse");
	}
	
	@PostMapping("CourseEditController")
	public void courseEditController(HttpServletRequest request, HttpServletResponse response)
	{
		Course course = new Course();
		
		course.setID(Integer.parseInt(request.getParameter("id")));
		course.setCourse_id(Integer.parseInt(request.getParameter("courseID")));
		course.setCourse_name(request.getParameter("courseName"));
		
		courseService.addCourse(course);
		try {
			response.sendRedirect("ViewCourse");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("CourseDeleteController")
	public void courseDeleteController(HttpServletRequest request, HttpServletResponse response)
	{
		int id = Integer.parseInt(request.getParameter("id"));
		courseService.deleteCourse(id);
		try {
			response.sendRedirect("ViewCourse");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
