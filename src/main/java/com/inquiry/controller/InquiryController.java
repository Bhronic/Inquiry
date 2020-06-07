package com.inquiry.controller;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.inquiry.model.Inquiry;
import com.inquiry.service.InquiryService;

@Controller
public class InquiryController {
	
	@Autowired
	InquiryService inquiryService;
	
	@PostMapping("InquiryFormController") 
	public ModelAndView inquiryForm(HttpServletRequest request, @ModelAttribute("inquiry") Inquiry inquiry) {
		
		HttpSession session=request.getSession(false);
		
		java.util.Date dt = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
		String idate = dateFormat.format(dt);
		
		inquiry.setInquiry_date(Date.valueOf(idate));
		
		inquiryService.addInquiry(inquiry);
		
		int count1 = (int) inquiryService.countAllInquiry();
		int count2 = inquiryService.countPengingInquiry(0);
		
		session.setAttribute("count1", count1);
		session.setAttribute("count2", count2);

		return new ModelAndView("redirect:/InquiryActivity?admin=" +(String)session.getAttribute("uname") +"&name=" +inquiry.getStudent_name());
	}
	
	@RequestMapping("ViewInquiry")
	public ModelAndView viewInquiry(HttpServletRequest request) {
		List<Inquiry> viewAllList = inquiryService.viewAllInquiry();
		List<Inquiry> viewDeletedList = inquiryService.viewDeletedInquiry(1);
		List<Inquiry> viewPendingList = inquiryService.viewPendingInquiry(0);
		
		request.setAttribute("viewAllList", viewAllList);
		request.setAttribute("viewDeletedList", viewDeletedList);
		request.setAttribute("viewPendingList", viewPendingList);
		return new ModelAndView("ViewInquiry");
	}
	
	@RequestMapping("EditForm")
	public ModelAndView editForm(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView("EditForm");
		
		int id = Integer.parseInt(request.getParameter("id"));
		Inquiry inquiry = inquiryService.findById(id);
		
		mav.addObject("inquiry", inquiry);
		return mav;
	}
	
	@PostMapping("InquiryEditController")
	public ModelAndView inquiryEditController(HttpServletRequest request, @ModelAttribute("inquiry") Inquiry inquiry) {
		
		inquiryService.addInquiry(inquiry);
		
		HttpSession session=request.getSession(false);
		
		return new ModelAndView("redirect:/InquiryEditActivity?admin=" +(String)session.getAttribute("uname") +"&name=" +inquiry.getStudent_name());
	}
	
	@RequestMapping("InquiryDeleteController")
	public ModelAndView deleteInquiry(HttpServletRequest request) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		Inquiry inquiry = inquiryService.findById(id);
		inquiry.setDel(1);
		inquiryService.addInquiry(inquiry);
		
		HttpSession session=request.getSession(false);
		int count2 = inquiryService.countPengingInquiry(0);
		session.setAttribute("count2", count2);
		
		return new ModelAndView("redirect:/InquiryDeleteActivity?admin=" +(String)session.getAttribute("uname") +"&name=" +inquiry.getStudent_name());
	}
	
	@RequestMapping("RetrieveInquiryController")
	public ModelAndView RetrieveInquiryController(HttpServletRequest request) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		Inquiry inquiry = inquiryService.findById(id);
		inquiry.setDel(0);
		
		inquiryService.addInquiry(inquiry);
		
		HttpSession session=request.getSession(false);
		int count2 = inquiryService.countPengingInquiry(0);
		session.setAttribute("count2", count2);
		
		return new ModelAndView("redirect:/InquiryRetrieveActivity?admin=" +(String)session.getAttribute("uname") +"&name=" +inquiry.getStudent_name());
	}

}
