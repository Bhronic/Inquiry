package com.inquiry.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.inquiry.model.FacultyCourse;
import com.inquiry.model.FacultyDetails;
import com.inquiry.service.FacultyService;

@Controller
public class FacultyController {
	
	@Autowired
	FacultyService facultyService;
	
	@RequestMapping("/ViewFaculty")
	public ModelAndView viewFaculty()
	{
		List<FacultyDetails> facultyDetails = facultyService.findAll();
		ModelAndView mv = new ModelAndView("ViewFaculty");
		mv.addObject("facultyList", facultyDetails);
		return mv;
	}
	
	@PostMapping("AddFacultyController")
	public ModelAndView addCourse(@ModelAttribute FacultyDetails faculty, @ModelAttribute FacultyCourse facultyCourse)
	{
		if(facultyCourse.getCourse() == null)
		{
			facultyService.addFaculty(faculty);
		}
		else
		{
			String course[] = facultyCourse.getCourse().split(",");
			
			List<FacultyCourse> courseList = new ArrayList<FacultyCourse>();
			
			for(int i = 0; i < course.length; i++)
			{
				FacultyCourse facultyCourse1 = new FacultyCourse();
				facultyCourse1.setCourse(course[i]);
				courseList.add(facultyCourse1);
			}
			
			faculty.setCourseList(courseList);
			facultyService.addFaculty(faculty);
		}
			
		return new ModelAndView("redirect:ViewFaculty");
	}
	
	@RequestMapping("EditFaculty")
	public ModelAndView editFaculty(@RequestParam int id)
	{
		FacultyDetails faculty = facultyService.findById(id);
		ModelAndView mv = new ModelAndView("EditFaculty");
		mv.addObject("faculty", faculty);
		return mv;
	}
	
	@PostMapping("FacultyEditController")
	public ModelAndView editFacultyController(@ModelAttribute FacultyDetails faculty, @ModelAttribute FacultyCourse facultyCourse)
	{
		if(facultyCourse.getCourse() == null)
		{
			facultyService.addFaculty(faculty);
		}
		else
		{
			String course[] = facultyCourse.getCourse().split(",");
			
			List<FacultyCourse> courseList = new ArrayList<FacultyCourse>();
			
			for(int i = 0; i < course.length; i++)
			{
				FacultyCourse facultyCourse1 = new FacultyCourse();
				facultyCourse1.setCourse(course[i]);
				courseList.add(facultyCourse1);
			}
			
			faculty.setCourseList(courseList);
			facultyService.addFaculty(faculty);
		}	
		ModelAndView mv = new ModelAndView("redirect:ViewFaculty");
		return mv;
	}
	
	@RequestMapping("FacultyDeleteController")
	public ModelAndView facultyDeleteController(@RequestParam int id)
	{
		facultyService.deleteById(id);
		return new ModelAndView("redirect:ViewFaculty");
	}
	
	@GetMapping("/facultyList")
	public ResponseEntity<List<FacultyDetails>> getFacultyList() {
		return new ResponseEntity<List<FacultyDetails>>(facultyService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping("/AddCourseFaculty")
	public ModelAndView addCourseFaculty(@RequestParam int facultyId[], @RequestParam String course)
	{
		for(int i = 0; i < facultyId.length; i++)
		{
			FacultyDetails facultyDetails = facultyService.findById(facultyId[i]);
			
			List<FacultyCourse> facultyCourseList = facultyDetails.getCourseList();
			
			FacultyCourse facultyCourse = new FacultyCourse();
			facultyCourse.setCourse(course);
			facultyCourseList.add(facultyCourse);
			facultyDetails.setCourseList(facultyCourseList);
			facultyService.addFaculty(facultyDetails);
		}
		return new ModelAndView("redirect:ViewCourse");
	}

}
