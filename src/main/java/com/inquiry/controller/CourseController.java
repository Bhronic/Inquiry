package com.inquiry.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ModelAndView addCourse(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView("redirect:ViewCourse");
		
		Course course = new Course();
		course.setCourse_id(Integer.parseInt(request.getParameter("courseID")));
		course.setCourse_name(request.getParameter("courseName"));
		
		if(request.getParameter("faculty") != null)
		{			
			String fId[] = request.getParameterValues("faculty");
			int i = 0;
			int[] facultyId = new int[fId.length]; 
			for(String str:fId)
			{
				facultyId[i] = Integer.parseInt(str);
				i++;	
			}
			mv = new ModelAndView("redirect:AddCourseFaculty");
			mv.addObject("facultyId", facultyId);
			mv.addObject("course", course.getCourse_name());
		}
		
		courseService.addCourse(course);
		
		return mv;
	}
	
	@RequestMapping("EditCourse")
	public ModelAndView editCourse(HttpServletRequest request)
	{
		Course course = courseService.findById(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("course", course);
		return new ModelAndView("EditCourse");
	}
	
	@PostMapping("CourseEditController")
	public ModelAndView courseEditController(HttpServletRequest request)
	{
		Course course = new Course();
		
		course.setID(Integer.parseInt(request.getParameter("id")));
		course.setCourse_id(Integer.parseInt(request.getParameter("courseID")));
		course.setCourse_name(request.getParameter("courseName"));
		
		courseService.addCourse(course);
		return new ModelAndView("redirect:ViewCourse");
	}
	
	@RequestMapping("CourseDeleteController")
	public ModelAndView courseDeleteController(HttpServletRequest request)
	{
		int id = Integer.parseInt(request.getParameter("id"));
		courseService.deleteCourse(id);
		return new ModelAndView("redirect:ViewCourse");
	}
	
	@RequestMapping("CourseList")
	public ModelAndView courseList(HttpServletRequest request)
	{
		List<Course> viewCourseList = courseService.viewAllCourse();
		request.setAttribute("viewCourseList", viewCourseList);
		return new ModelAndView(request.getParameter("url"));
	}
	
	@GetMapping("/courseList")
	public ResponseEntity<List<Course>> getCourseList() {
		return new ResponseEntity<List<Course>>(courseService.viewAllCourse(), HttpStatus.OK);
	}
	
	@GetMapping("/coursePage")
	public ResponseEntity<List<Course>> getCoursePage() {
		Page<Course> page = courseService.findPage(PageRequest.of(1, 5));
		int totalPage = page.getTotalPages();
		System.out.println(totalPage);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("totalPage", String.valueOf(totalPage));
		ResponseEntity<List<Course>> entity = new ResponseEntity<List<Course>>(courseService.findPage(PageRequest.of(1, 5)).getContent(), HttpStatus.OK);
		return entity;
	}
	
	@GetMapping("/courseSearch")
	public ResponseEntity<List<Course>> getCourseSearch(@RequestParam String search) {
		return new ResponseEntity<List<Course>>(courseService.search(search), HttpStatus.OK);
	}

}
