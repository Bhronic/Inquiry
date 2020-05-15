package com.inquiry.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.stereotype.Controller
public class Controller {
	
	@RequestMapping("/")
	public ModelAndView login()
	{
		return new ModelAndView("Login");
	}
	
	@RequestMapping("/Login")
	public ModelAndView login1()
	{
		return new ModelAndView("Login");
	}
	
	@RequestMapping("/SignUp")
	public ModelAndView signUp()
	{
		return new ModelAndView("SignUp");
	}
	
	@RequestMapping("/index")
	public ModelAndView index()
	{
		return new ModelAndView("index");
	}

	@RequestMapping("/InquiryForm")
	public ModelAndView inquiryForm()
	{
		return new ModelAndView("InquiryForm");
	}
	
}
