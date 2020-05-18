package com.inquiry.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.inquiry.model.Activity;
import com.inquiry.model.Fees;
import com.inquiry.model.Student;
import com.inquiry.repository.ActivityRepository;
import com.inquiry.service.FeesService;

@Controller
public class FeesController {
	
	@Autowired
	FeesService feesService;
	@Autowired
	ActivityRepository activityRepository;
	
	@RequestMapping("ViewFees")
	public ModelAndView viewFees(HttpServletRequest request, HttpServletResponse response) {
		List<Student> viewFeesPaidList = feesService.findAllPaidFees();
		List<Student> viewFeesPendingList = feesService.findAllPendingFees();
		List<Student> viewFeesDueList = feesService.findAllPendingFees();
		
		request.setAttribute("viewFeesPaidList", viewFeesPaidList);
		request.setAttribute("viewFeesPendingList", viewFeesPendingList);
		request.setAttribute("viewFeesDueList", viewFeesDueList);
		return new ModelAndView("ViewFees");
	}
	
	@RequestMapping("PayFee")
	public ModelAndView payFee(HttpServletRequest request) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		Student student = feesService.findStudentById(id);
		
		request.setAttribute("student", student);
		
		return new ModelAndView("PayFee");
	}
	
	@PostMapping("PayFeeController")
	public void studentEditController(HttpServletRequest request, HttpServletResponse response) {
		
		java.util.Date d = Calendar.getInstance().getTime(); 
		DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
		String dt = dateFormat.format(d);
		Date date =  Date.valueOf(dt);
		int id = Integer.parseInt(request.getParameter("id"));
		double amount = Double.parseDouble(request.getParameter("amount"));
		
		Fees fees = new Fees();
		
		fees.setDate(date);
		fees.setStudentId(id);
		fees.setStudent_name(request.getParameter("studentName"));
		fees.setMethod(request.getParameter("method"));
		fees.setFees_amount(amount);
		
		feesService.payFees(fees);
		
		Student student = feesService.findStudentById(id);
		student.setFeesPaid(student.getFeesPaid() + amount);
		
		feesService.saveStudent(student.getID(), student.getFeesPaid());
		
		HttpSession session = request.getSession();
		int count4 = feesService.countPendingFees();
		session.setAttribute("count4", count4);
		
		Activity activity = new Activity();
		java.util.Date dt1 = Calendar.getInstance().getTime(); 
		DateFormat dateFormat1 = new SimpleDateFormat("dd-MM-YYYY HH:mm:ss");
		String date1 = dateFormat1.format(dt1);
		activity.setAdminName((String)session.getAttribute("uname"));
		activity.setDate_time(date1);
		activity.setType("Pay Fee");
		activity.setDescription("Pay fee of " +fees.getStudent_name() +" Amount:" +fees.getFees_amount());
		activityRepository.save(activity);
		
		try {
			response.sendRedirect("ViewFees");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
