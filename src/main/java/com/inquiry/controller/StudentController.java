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
import com.inquiry.model.Inquiry;
import com.inquiry.model.Student;
import com.inquiry.repository.ActivityRepository;
import com.inquiry.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	StudentService studentService;
	@Autowired
	ActivityRepository activityRepository;
	
	@RequestMapping("StudentForm")
	public ModelAndView studentForm(HttpServletRequest request) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		Inquiry inquiry = studentService.findInquiryById(id);
		
		request.setAttribute("inquiry", inquiry);
		
		return new ModelAndView("StudentForm");
	}
	
	@PostMapping("StudentFormController") 
	public void studentForm(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session=request.getSession(false);
		
		java.util.Date dt = Calendar.getInstance().getTime(); 
		DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
		String joining_date = dateFormat.format(dt);
		int id = Integer.parseInt(request.getParameter("id"));
		Date birthDate = Date.valueOf(request.getParameter("birthDate"));
		Date joiningDate = Date.valueOf(joining_date);
		double fees = Double.parseDouble(request.getParameter("fees"));

		Student student= new Student();
		
		student.setID(id);
		student.setStudent_name(request.getParameter("studentName"));
		student.setMob_no(request.getParameter("mobileNumber"));
		student.setEmail(request.getParameter("email"));
		student.setDob(birthDate);
		student.setAddress(request.getParameter("address"));
		student.setQualification(request.getParameter("qualification"));
		student.setCourse(request.getParameter("course"));
		student.setBatch_time(request.getParameter("batchTime"));
		student.setJoining_date(joiningDate);
		student.setFees(fees);
		student.setTeacher(request.getParameter("teacher_appointed"));
		student.setFeesPaid((double) 0);
		
		studentService.deleteInquiryById(id);
		
		studentService.addStudent(student);
		
		Activity activity = new Activity();
		java.util.Date dt1 = Calendar.getInstance().getTime(); 
		DateFormat dateFormat1 = new SimpleDateFormat("dd-MM-YYYY HH:mm:ss");
		String date1 = dateFormat1.format(dt1);
		activity.setAdminName((String)session.getAttribute("uname"));
		activity.setDate_time(date1);
		activity.setType("New Student");
		activity.setDescription("New Student " +student.getStudent_name());
		activityRepository.save(activity);
		
		int count1 = (int) session.getAttribute("count1");
		int count2 = (int) session.getAttribute("count2");
		int count3 = (int) session.getAttribute("count3");
		int count4 = (int) session.getAttribute("count4");
		
		session.setAttribute("count1", count1-1);
		session.setAttribute("count2", count2-1);
		session.setAttribute("count3", count3+1);
		session.setAttribute("count4", count4+1);
		try {
			response.sendRedirect("index");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("ViewStudent")
	public ModelAndView viewInquiry(HttpServletRequest request, HttpServletResponse response) {
		List<Student> viewAllList = studentService.viewAllStudent();
		List<Student> viewDeletedList = studentService.viewDeletedStudent(1);
		List<Student> viewPendingList = studentService.viewPendingStudent(0);
		
		request.setAttribute("viewAllList", viewAllList);
		request.setAttribute("viewDeletedList", viewDeletedList);
		request.setAttribute("viewPendingList", viewPendingList);
		return new ModelAndView("ViewStudent");
	}
	
	@RequestMapping("EditStudent")
	public ModelAndView editForm(HttpServletRequest request) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		Student student = studentService.findById(id);
		
		request.setAttribute("student", student);
		
		return new ModelAndView("EditStudent");
	}
	
	@PostMapping("StudentEditController")
	public void studentEditController(HttpServletRequest request, HttpServletResponse response) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		Date birthDate = Date.valueOf(request.getParameter("birthDate"));
		Date joiningDate = Date.valueOf(request.getParameter("joiningDate"));
		double fees = Double.parseDouble(request.getParameter("fees"));

		Student student= new Student();
		
		student.setID(id);
		student.setStudent_name(request.getParameter("studentName"));
		student.setMob_no(request.getParameter("mobileNumber"));
		student.setEmail(request.getParameter("email"));
		student.setDob(birthDate);
		student.setAddress(request.getParameter("address"));
		student.setQualification(request.getParameter("qualification"));
		student.setCourse(request.getParameter("course"));
		student.setBatch_time(request.getParameter("batchTime"));
		student.setJoining_date(joiningDate);
		student.setFees(fees);
		student.setTeacher(request.getParameter("teacher_appointed"));
		student.setFeesPaid((double) 0);
		
		studentService.addStudent(student);
		
		HttpSession session=request.getSession(false);
		
		Activity activity = new Activity();
		java.util.Date dt1 = Calendar.getInstance().getTime(); 
		DateFormat dateFormat1 = new SimpleDateFormat("dd-MM-YYYY HH:mm:ss");
		String date1 = dateFormat1.format(dt1);
		activity.setAdminName((String)session.getAttribute("uname"));
		activity.setDate_time(date1);
		activity.setType("Edit Student");
		activity.setDescription("Edit Student " +student.getStudent_name());
		activityRepository.save(activity);
		
		try {
			response.sendRedirect("ViewStudent");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("StudentDeleteController")
	public void deleteInquiry(HttpServletRequest request, HttpServletResponse response) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		Student student = studentService.findById(id);
		student.setDel(1);
		
		studentService.addStudent(student);
		
		HttpSession session=request.getSession(false);
		int count3 = (int) session.getAttribute("count3");
		session.setAttribute("count3", count3-1);
		
		Activity activity = new Activity();
		java.util.Date dt1 = Calendar.getInstance().getTime(); 
		DateFormat dateFormat1 = new SimpleDateFormat("dd-MM-YYYY HH:mm:ss");
		String date1 = dateFormat1.format(dt1);
		activity.setAdminName((String)session.getAttribute("uname"));
		activity.setDate_time(date1);
		activity.setType("Delete Student");
		activity.setDescription("Delete Student " +student.getStudent_name());
		activityRepository.save(activity);
		
		try {
			response.sendRedirect("ViewStudent");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("RetrieveStudentController")
	public void RetrieveInquiryController(HttpServletRequest request, HttpServletResponse response) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		Student student = studentService.findById(id);
		student.setDel(0);
		
		studentService.addStudent(student);
		
		HttpSession session=request.getSession(false);
		int count3 = (int) session.getAttribute("count3");
		session.setAttribute("count3", count3+1);
		
		Activity activity = new Activity();
		java.util.Date dt1 = Calendar.getInstance().getTime(); 
		DateFormat dateFormat1 = new SimpleDateFormat("dd-MM-YYYY HH:mm:ss");
		String date1 = dateFormat1.format(dt1);
		activity.setAdminName((String)session.getAttribute("uname"));
		activity.setDate_time(date1);
		activity.setType("Retrieve Student");
		activity.setDescription("Retrieve Student " +student.getStudent_name());
		activityRepository.save(activity);
		
		try {
			response.sendRedirect("ViewStudent");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("ViewStudentDetails")
	public ModelAndView viewStudentDetails(HttpServletRequest request) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		Student student = studentService.findById(id);
		
		request.setAttribute("student", student);
		
		return new ModelAndView("ViewStudentDetails");
	}
	
	@RequestMapping("ViewPaymentHistory")
	public ModelAndView viewPaymentHistory(HttpServletRequest request) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		Student student = studentService.findById(id);
		
		request.setAttribute("student", student);
		
		List<Fees> feesHistoryList = studentService.findFeesHistoryById(id);
		request.setAttribute("feesHistoryList", feesHistoryList);
		
		return new ModelAndView("ViewPaymentHistory");
	}

}
