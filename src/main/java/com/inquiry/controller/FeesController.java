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

import com.inquiry.model.Fees;
import com.inquiry.model.Student;
import com.inquiry.repository.StudentRepository;
import com.inquiry.service.FeesService;

@Controller
public class FeesController {
	
	@Autowired
	FeesService feesService;
	@Autowired
	StudentRepository studentRepository;
	
	@RequestMapping("ViewFees")
	public ModelAndView viewFees(HttpServletRequest request, HttpServletResponse response) {
		List<Student> viewFeesPaidList = studentRepository.findAllPaidFees();
		List<Student> viewFeesPendingList = studentRepository.findAllPendingFees();
		List<Student> viewFeesDueList = studentRepository.findAllPendingFees();
		
		request.setAttribute("viewFeesPaidList", viewFeesPaidList);
		request.setAttribute("viewFeesPendingList", viewFeesPendingList);
		request.setAttribute("viewFeesDueList", viewFeesDueList);
		return new ModelAndView("ViewFees");
	}
	
	@RequestMapping("PayFee")
	public ModelAndView payFee(HttpServletRequest request) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		Optional<Student> student = studentRepository.findById(id);
		
		request.setAttribute("student", student);
		
		return new ModelAndView("PayFee");
	}
	
	@PostMapping("PayFeeController")
	public void studentEditController(HttpServletRequest request, HttpServletResponse response) {
		
		java.util.Date d = Calendar.getInstance().getTime(); 
		DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
		String dt = dateFormat.format(d);
		Date date =  Date.valueOf(dt);
		System.out.println(request.getParameter("id"));
		int id = Integer.parseInt(request.getParameter("id"));
		double amount = Double.parseDouble(request.getParameter("amount"));
		
		Fees fees = new Fees();
		
		fees.setDate(date);
		fees.setStudentId(id);
		fees.setStudent_name(request.getParameter("studentName"));
		fees.setMethod(request.getParameter("method"));
		fees.setFees_amount(amount);
		
		feesService.payFees(fees);
		
		Student student = studentRepository.findByID(id);
		student.setFees_paid(student.getFees_paid() + amount);
		
		studentRepository.save(student);
		
		HttpSession session = request.getSession();
		int count4 = studentRepository.countPendingFees();
		session.setAttribute("count4", count4);
		
		try {
			response.sendRedirect("ViewFees");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
