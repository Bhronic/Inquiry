package com.inquiry.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.inquiry.model.TeacherCourse;
import com.inquiry.model.TeacherDetails;
import com.inquiry.service.TeacherService;

@Controller
public class TeacherController {
	
	@Autowired
	TeacherService teacherService;
	
	@RequestMapping("/ViewTeacher")
	public ModelAndView viewTeacher()
	{
		List<TeacherDetails> teacherDetails = teacherService.findAll();
		ModelAndView mv = new ModelAndView("ViewTeacher");
		mv.addObject("teacherList", teacherDetails);
		return mv;
	}
	
	@PostMapping("AddTeacherController")
	public ModelAndView addCourse(@ModelAttribute TeacherDetails teacher, @ModelAttribute TeacherCourse teacherCourse)
	{
		if(teacherCourse.equals(null))
		{
			String course[] = teacherCourse.getCourse().split(",");
			
			List<TeacherCourse> courseList = new ArrayList<TeacherCourse>();
			
			for(int i = 0; i < course.length; i++)
			{
				TeacherCourse teacherCourse1 = new TeacherCourse();
				teacherCourse1.setCourse(course[i]);
				courseList.add(teacherCourse1);
			}
			
			teacher.setCourseList(courseList);
		}
		teacherService.addTeacher(teacher);
			
		return new ModelAndView("redirect:ViewTeacher");
	}

}
