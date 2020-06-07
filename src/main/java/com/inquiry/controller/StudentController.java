package com.inquiry.controller;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import com.inquiry.model.Fees;
import com.inquiry.model.Inquiry;
import com.inquiry.model.StudentCourse;
import com.inquiry.model.StudentDetails;
import com.inquiry.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping("StudentForm")
	public ModelAndView studentForm(HttpServletRequest request) {
		
		Inquiry inquiry = studentService.findInquiryById(Integer.parseInt(request.getParameter("id")));
		
		request.setAttribute("inquiry", inquiry);
		
		return new ModelAndView("StudentForm");
	}
	
	@PostMapping("StudentFormController") 
	public ModelAndView studentFormController(HttpServletRequest request) {
		
		HttpSession session=request.getSession(false);
		
		java.util.Date dt = Calendar.getInstance().getTime(); 
		DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
		String joining_date = dateFormat.format(dt);
		int id = Integer.parseInt(request.getParameter("id"));
		Date birthDate = Date.valueOf(request.getParameter("birthDate"));
		Date joiningDate = Date.valueOf(joining_date);
		double fees = Double.parseDouble(request.getParameter("fees"));
		
		StudentCourse studentCourse = new StudentCourse();
		studentCourse.setCourse(request.getParameter("course"));
		studentCourse.setBatch_time(request.getParameter("batchTime"));
		studentCourse.setJoining_date(joiningDate);
		studentCourse.setFees(fees);
		studentCourse.setTeacher(request.getParameter("teacher_appointed"));
		studentCourse.setFeesPaid((double) 0);
		studentCourse.setLast_fees_paid(joiningDate);
		
		List<StudentCourse> studentCourseList = new ArrayList<StudentCourse>();
		studentCourseList.add(studentCourse);
		
		StudentDetails studentDtls= new StudentDetails();
		
		studentDtls.setID(id);
		studentDtls.setStudent_name(request.getParameter("studentName"));
		studentDtls.setMob_no(request.getParameter("mobileNumber"));
		studentDtls.setEmail(request.getParameter("email"));
		studentDtls.setDob(birthDate);
		studentDtls.setAddress(request.getParameter("address"));
		studentDtls.setQualification(request.getParameter("qualification"));
		studentDtls.setTotal_course(1);
		studentDtls.setStudentCourse(studentCourseList);
		
		studentService.deleteInquiryById(id);
		
		studentService.addStudent(studentDtls);
		
		int count1 = (int) session.getAttribute("count1");
		int count2 = (int) session.getAttribute("count2");
		int count3 = (int) session.getAttribute("count3");
		int count4 = (int) session.getAttribute("count4");
		
		session.setAttribute("count1", count1-1);
		session.setAttribute("count2", count2-1);
		session.setAttribute("count3", count3+1);
		session.setAttribute("count4", count4+1);
		return new ModelAndView("redirect:NewStudentActivity?admin=" +(String)session.getAttribute("uname") +"&name=" +studentDtls.getStudent_name());
	}
	
	@RequestMapping("ViewStudent")
	public ModelAndView viewInquiry() {
		ModelAndView mav = null;
		
		List<StudentDetails> viewAllList = studentService.viewAllStudent();
		List<StudentDetails> viewDeletedList = studentService.viewDeletedStudent(1);
		List<StudentDetails> viewPendingList = studentService.viewPendingStudent(0);
		
		mav = new ModelAndView("ViewStudent");
		mav.addObject("viewAllList", viewAllList);
		mav.addObject("viewDeletedList", viewDeletedList);
		mav.addObject("viewPendingList", viewPendingList);
		
		return mav;
	}
	
	@RequestMapping("EditStudent")
	public ModelAndView editForm(HttpServletRequest request) {
		ModelAndView mav = null;
		
		int id = Integer.parseInt(request.getParameter("id"));
		StudentDetails student = studentService.findById(id);
		
		mav = new ModelAndView("EditStudent");
		mav.addObject("student", student);
		
		return mav;
	}
	
	@PostMapping("StudentEditController")
	public ModelAndView studentEditController(HttpServletRequest request) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		Date birthDate = Date.valueOf(request.getParameter("birthDate"));
		Date joiningDate = Date.valueOf(request.getParameter("joiningDate"));
		double fees = Double.parseDouble(request.getParameter("fees"));
		
		StudentDetails studentDtls = studentService.findById(id);
				
		List<StudentCourse> studentCourseList = studentDtls.getStudentCourse();
		for(StudentCourse studentCourse : studentCourseList)
		{
			if(studentCourse.getStatus() == 0)
			{
				studentCourse.setCourse(request.getParameter("course"));
				studentCourse.setBatch_time(request.getParameter("batchTime"));
				studentCourse.setJoining_date(joiningDate);
				studentCourse.setFees(fees);
				studentCourse.setTeacher(request.getParameter("teacher_appointed"));
			}
		}
		
		studentDtls.setStudent_name(request.getParameter("studentName"));
		studentDtls.setMob_no(request.getParameter("mobileNumber"));
		studentDtls.setEmail(request.getParameter("email"));
		studentDtls.setDob(birthDate);
		studentDtls.setAddress(request.getParameter("address"));
		studentDtls.setQualification(request.getParameter("qualification"));
		studentDtls.setStudentCourse(studentCourseList);
		
		studentService.addStudent(studentDtls);
		
		HttpSession session=request.getSession(false);
		
		return new ModelAndView("redirect:StudentEditActivity?admin=" +(String)session.getAttribute("uname") +"&name=" +studentDtls.getStudent_name());
	}
	
	@RequestMapping("StudentDeleteController")
	public ModelAndView deleteInquiry(HttpServletRequest request) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		StudentDetails studentDtls = studentService.findById(id);
		studentDtls.setDel(1);
		
		studentService.addStudent(studentDtls);
		
		HttpSession session=request.getSession(false);
		int count3 = (int) session.getAttribute("count3");
		session.setAttribute("count3", count3-1);
		
		return new ModelAndView("redirect:StudentDeleteActivity?admin=" +(String)session.getAttribute("uname") +"&name=" +studentDtls.getStudent_name());
	}
	
	@RequestMapping("RetrieveStudentController")
	public ModelAndView RetrieveInquiryController(HttpServletRequest request) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		StudentDetails studentDtls = studentService.findById(id);
		studentDtls.setDel(0);
		
		studentService.addStudent(studentDtls);
		
		HttpSession session=request.getSession(false);
		int count3 = (int) session.getAttribute("count3");
		session.setAttribute("count3", count3+1);
		
		return new ModelAndView("redirect:StudentRetrieveActivity?admin=" +(String)session.getAttribute("uname") +"&name=" +studentDtls.getStudent_name());
	}
	
	@RequestMapping("ViewStudentDetails")
	public ModelAndView viewStudentDetails(HttpServletRequest request) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		StudentDetails studentDtls = studentService.findById(id);
		
		request.setAttribute("student", studentDtls);
		
		return new ModelAndView("ViewStudentDetails");
	}
	
	@RequestMapping("ViewPaymentHistory")
	public ModelAndView viewPaymentHistory(HttpServletRequest request) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		StudentDetails studentDtls = studentService.findById(id);
		
		request.setAttribute("student", studentDtls);
		
		StudentDetails feesHistoryList = studentService.findById(id);
		request.setAttribute("feesHistoryList", feesHistoryList);
		
		return new ModelAndView("ViewPaymentHistory");
	}
	
	@RequestMapping("ViewFees")
	public ModelAndView viewFees(HttpServletRequest request, HttpServletResponse response) {
		List<StudentDetails> viewFeesPaidList = studentService.findAllPaidOrPendingFees();
		List<StudentDetails> viewFeesPendingList = studentService.findAllPaidOrPendingFees();
		List<StudentDetails> viewFeesDueList = studentService.findAllPaidOrPendingFees();
		
		request.setAttribute("viewFeesPaidList", viewFeesPaidList);
		request.setAttribute("viewFeesPendingList", viewFeesPendingList);
		request.setAttribute("viewFeesDueList", viewFeesDueList);
		return new ModelAndView("ViewFees");
	}
	
	@RequestMapping("PayFee")
	public ModelAndView payFee(HttpServletRequest request) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		StudentDetails student = studentService.findById(id);
		
		request.setAttribute("student", student);
		
		return new ModelAndView("PayFee");
	}
	
	@PostMapping("PayFeeController")
	public ModelAndView payFeeController(HttpServletRequest request) {
		
		java.util.Date d = Calendar.getInstance().getTime(); 
		DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
		String dt = dateFormat.format(d);
		Date date =  Date.valueOf(dt);
		int id = Integer.parseInt(request.getParameter("id"));
		double amount = Double.parseDouble(request.getParameter("amount"));
		
		Fees fees = new Fees();
		
		fees.setDate(date);
		fees.setStudent_name(request.getParameter("studentName"));
		fees.setMethod(request.getParameter("method"));
		fees.setFees_amount(amount);
		
		StudentDetails student = studentService.findById(id);
		
		List<Fees> studentFeeList = student.getFeesTable();
		studentFeeList.add(fees);
		
		List<StudentCourse> list1 = student.getStudentCourse();
		for(StudentCourse studentCourse :list1)
		{
			if(studentCourse.getStatus() == 0)
			{
				studentCourse.setFeesPaid(studentCourse.getFeesPaid() + amount);
				studentCourse.setLast_fees_paid(date);
			}
		}	
		student.setFeesTable(studentFeeList);
		studentService.addStudent(student);
		
		HttpSession session = request.getSession();
		//int count4 = studentService.countPendingFees();
		//session.setAttribute("count4", count4);
		
		return new ModelAndView("redirect:PayFeesActivity?admin=" +(String)session.getAttribute("uname") +"&name=" +fees.getStudent_name() +"&amount=" +fees.getFees_amount());
	}
	
	@RequestMapping("UpdateStudentStatus")
	public ModelAndView updateStudentStatus(HttpServletRequest request)
	{
		
		StudentDetails student = studentService.findById(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("student", student);
		return new ModelAndView("UpdateStudentStatus");
	}
	
	@PostMapping("UpdateStudentStatusController")
	public ModelAndView updateStudentStatusController(HttpServletRequest request)
	{
		java.util.Date dt = Calendar.getInstance().getTime(); 
		DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
		String completion_date = dateFormat.format(dt);
		Date completionDate = Date.valueOf(completion_date);
		
		int status = Integer.parseInt(request.getParameter("status"));
		
		StudentDetails studentDtls = studentService.findById(Integer.parseInt(request.getParameter("id")));
		
		List<StudentCourse> studentCourseList = studentDtls.getStudentCourse();
		for(StudentCourse studentCourse : studentCourseList)
		{
			if(studentCourse.getStatus() == 0)
			{
				studentCourse.setCompletion_date(completionDate);
				studentDtls.setDel(1);
				studentCourse.setStatus(status);
				if(status == 1)
				{
					studentCourse.setScore(Integer.parseInt(request.getParameter("score")));
					studentCourse.setCertificate(Integer.parseInt(request.getParameter("certificate")));
					studentDtls.setCourse_completed(studentDtls.getCourse_completed() + 1);
					studentDtls.setDel(1);
				}
			}
		}
		
		studentDtls.setStudentCourse(studentCourseList);
		
		studentService.addStudent(studentDtls);
		
		return new ModelAndView("redirect:ViewStudent");
	}
	
	@RequestMapping("StudentNewCourse")
	public ModelAndView studentNewCourse(HttpServletRequest request) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		StudentDetails student = studentService.findById(id);
		
		request.setAttribute("student", student);
		
		return new ModelAndView("StudentNewCourse");
	}
	
	@PostMapping("StudentNewCourseController")
	public ModelAndView studentNewCourseController(HttpServletRequest request)
	{
		java.util.Date dt = Calendar.getInstance().getTime(); 
		DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
		String joining_date = dateFormat.format(dt);
		int id = Integer.parseInt(request.getParameter("id"));
		Date joiningDate = Date.valueOf(joining_date);
		double fees = Double.parseDouble(request.getParameter("fees")); 
		
		StudentDetails studentDtls = studentService.findById(id);
		
		StudentCourse studentCourse = new StudentCourse();
		studentCourse.setCourse(request.getParameter("course"));
		studentCourse.setBatch_time(request.getParameter("batchTime"));
		studentCourse.setJoining_date(joiningDate);
		studentCourse.setFees(fees);
		studentCourse.setTeacher(request.getParameter("teacher_appointed"));
		studentCourse.setFeesPaid((double) 0);
		
		List<StudentCourse> studentCourseList = studentDtls.getStudentCourse();
		studentCourseList.add(studentCourse);
		
		studentDtls.setStudent_name(request.getParameter("studentName"));
		studentDtls.setMob_no(request.getParameter("mobileNumber"));
		studentDtls.setEmail(request.getParameter("email"));
		studentDtls.setAddress(request.getParameter("address"));
		studentDtls.setQualification(request.getParameter("qualification"));
		studentDtls.setDel(0);
		studentDtls.setTotal_course(studentDtls.getTotal_course() + 1);
		studentDtls.setStudentCourse(studentCourseList);
		
		studentService.addStudent(studentDtls);
		
		return new ModelAndView("redirect:ViewStudent");
	}
	
	@RequestMapping("ViewCourseHistory")
	public ModelAndView viewCourseHistory(HttpServletRequest request) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		StudentDetails studentDtls = studentService.findById(id);
		
		request.setAttribute("student", studentDtls);
		
		StudentDetails feesCourseList = studentService.findById(id);
		request.setAttribute("feesCourseList", feesCourseList);
		
		return new ModelAndView("ViewCourseHistory");
	}

}
