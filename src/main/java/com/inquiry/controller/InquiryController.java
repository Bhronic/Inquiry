package com.inquiry.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.inquiry.model.Inquiry;
import com.inquiry.repository.InquiryRepository;
import com.inquiry.service.InquiryService;

@Controller
public class InquiryController {
	
	@Autowired
	InquiryService inquiryService;
	@Autowired
	InquiryRepository inquiryRepository;
	@Autowired
	ActivityController activityController;
	
	@PostMapping("InquiryFormController") 
	public void inquiryForm(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session=request.getSession(false);
		
		java.util.Date dt = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
		String inquiry_date = dateFormat.format(dt);
		Date inquiryDate =  Date.valueOf(inquiry_date);
		Date birthDate = Date.valueOf(request.getParameter("birthDate"));
		Date joiningDate = Date.valueOf(request.getParameter("joiningDate"));
		
		Inquiry inquiry = new Inquiry();
		
		inquiry.setInquiry_date(inquiryDate);
		inquiry.setStudent_name(request.getParameter("studentName"));
		inquiry.setMob_no(request.getParameter("mobileNumber"));
		inquiry.setEmail(request.getParameter("email"));
		inquiry.setDob(birthDate);
		inquiry.setAddress(request.getParameter("address"));
		inquiry.setQualification(request.getParameter("qualification"));
		inquiry.setCourse(request.getParameter("course"));
		inquiry.setBatch_time(request.getParameter("batchTime"));
		inquiry.setJoining_date(joiningDate);
		inquiry.setDel(0);
		
		inquiryService.addInquiry(inquiry);
		
		activityController.newInquiryActivity((String)session.getAttribute("uname"), inquiry.getStudent_name());
		
		int count1 = (int) inquiryRepository.count();
		int count2 = inquiryRepository.countByDel(0);
		
		session.setAttribute("count1", count1);
		session.setAttribute("count2", count2);
		try {
			response.sendRedirect("index");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("ViewInquiry")
	public ModelAndView viewInquiry(HttpServletRequest request, HttpServletResponse response) {
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
		
		int id = Integer.parseInt(request.getParameter("id"));
		Optional<Inquiry> inquiry = inquiryRepository.findById(id);
		
		request.setAttribute("inquiry", inquiry);
		
		return new ModelAndView("EditForm");
	}
	
	@PostMapping("InquiryEditController")
	public void inquiryEditController(HttpServletRequest request, HttpServletResponse response) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		Date inquiryDate =  Date.valueOf(request.getParameter("inquiryDate"));
		Date birthDate = Date.valueOf(request.getParameter("birthDate"));
		Date joiningDate = Date.valueOf(request.getParameter("joiningDate"));

		Inquiry inquiry= new Inquiry();
		
		inquiry.setID(id);
		inquiry.setInquiry_date(inquiryDate);
		inquiry.setStudent_name(request.getParameter("studentName"));
		inquiry.setMob_no(request.getParameter("mobileNumber"));
		inquiry.setEmail(request.getParameter("email"));
		inquiry.setDob(birthDate);
		inquiry.setAddress(request.getParameter("address"));
		inquiry.setQualification(request.getParameter("qualification"));
		inquiry.setCourse(request.getParameter("course"));
		inquiry.setBatch_time(request.getParameter("batchTime"));
		inquiry.setJoining_date(joiningDate);
		
		inquiryService.addInquiry(inquiry);
		
		HttpSession session=request.getSession(false);
		
		activityController.editInquiryActivity((String)session.getAttribute("uname"), inquiry.getStudent_name());
		
		try {
			response.sendRedirect("ViewInquiry");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("InquiryDeleteController")
	public void deleteInquiry(HttpServletRequest request, HttpServletResponse response) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		Inquiry inquiry = inquiryRepository.findByID(id);
		inquiry.setDel(1);
		
		inquiryRepository.save(inquiry);
		
		HttpSession session=request.getSession(false);
		int count2 = inquiryRepository.countByDel(0);
		session.setAttribute("count2", count2);
		
		activityController.deleteInquiryActivity((String)session.getAttribute("uname"), inquiry.getStudent_name());
		
		try {
			response.sendRedirect("ViewInquiry");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("RetrieveInquiryController")
	public void RetrieveInquiryController(HttpServletRequest request, HttpServletResponse response) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		Inquiry inquiry = inquiryRepository.findByID(id);
		inquiry.setDel(0);
		
		inquiryRepository.save(inquiry);
		
		HttpSession session=request.getSession(false);
		int count2 = inquiryRepository.countByDel(0);
		session.setAttribute("count2", count2);
		
		activityController.retrieveInquiryActivity((String)session.getAttribute("uname"), inquiry.getStudent_name());
		
		try {
			response.sendRedirect("ViewInquiry");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
