package com.inquiry.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.inquiry.model.Activity;
import com.inquiry.repository.ActivityRepository;

@Controller
public class ActivityController {
	
	@Autowired
	ActivityRepository activityRepository;
	
	@RequestMapping("ViewActivity")
	public ModelAndView viewActivity(HttpServletRequest request, HttpServletResponse response) {
		String uname = request.getParameter("admin");
		List<Activity> activityList = activityRepository.findAllByAdminName(uname);
		request.setAttribute("activityList", activityList);
		return new ModelAndView("ViewActivity");
	}

}
