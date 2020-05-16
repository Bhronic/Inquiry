package com.inquiry.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
	Activity activity = new Activity();
	
	@RequestMapping("ViewActivity")
	public ModelAndView viewActivity(HttpServletRequest request, HttpServletResponse response) {
		String uname = request.getParameter("admin");
		List<Activity> activityList = activityRepository.findAllByAdminName(uname);
		request.setAttribute("activityList", activityList);
		return new ModelAndView("ViewActivity");
	}
	
	public String date() {
		Date dt = Calendar.getInstance().getTime(); 
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH:mm:ss");
		String date = dateFormat.format(dt);
		return date;
	}
	
	//User Activity Starts
	
	public void loginActivity(String username) {
		activity.setAdminName(username);
		activity.setDate_time(date());
		activity.setType("SignIn");
		activityRepository.save(activity);
	}
	
	public void signUpActivity(String username) {
		activity.setAdminName("jaymodi99");
		activity.setDate_time(date());
		activity.setType("SignUp");
		activity.setDescription("New Admin " +username);
		activityRepository.save(activity);
	}
	
	public void deleteUserActivity(String username) {
		activity.setAdminName("jaymodi99");
		activity.setDate_time(date());
		activity.setType("Delete Admin");
		activity.setDescription("Delete Admin " +username);
		activityRepository.save(activity);
	}

//Inquiry Activity Starts	
	
	public void newInquiryActivity(String username, String studentName) {
		activity.setAdminName(username);
		activity.setDate_time(date());
		activity.setType("New Inquiry");
		activity.setDescription("New Inquiry " +studentName);
		activityRepository.save(activity);
	}
	
	public void editInquiryActivity(String username, String studentName) {
		activity.setAdminName(username);
		activity.setDate_time(date());
		activity.setType("Edit Inquiry");
		activity.setDescription("Edit Inquiry " +studentName);
		activityRepository.save(activity);
	}
	
	public void deleteInquiryActivity(String username, String studentName) {
		activity.setAdminName(username);
		activity.setDate_time(date());
		activity.setType("Delete Inquiry");
		activity.setDescription("Delete Inquiry " +studentName);
		activityRepository.save(activity);
	}
	
	public void retrieveInquiryActivity(String username, String studentName) {
		activity.setAdminName(username);
		activity.setDate_time(date());
		activity.setType("Retrieve Inquiry");
		activity.setDescription("Retrieve Inquiry " +studentName);
		activityRepository.save(activity);
	}
	
//Student Activity Starts
	
	public void addStudentActivity(String username, String studentName) {
		activity.setAdminName(username);
		activity.setDate_time(date());
		activity.setType("New Student");
		activity.setDescription("New Student " +studentName);
		activityRepository.save(activity);
	}
	
	public void editStudentActivity(String username, String studentName) {
		activity.setAdminName(username);
		activity.setDate_time(date());
		activity.setType("Edit Student");
		activity.setDescription("Edit Student " +studentName);
		activityRepository.save(activity);
	}
	
	public void deleteStudentActivity(String username, String studentName) {
		activity.setAdminName(username);
		activity.setDate_time(date());
		activity.setType("Delete Student");
		activity.setDescription("Delete Student " +studentName);
		activityRepository.save(activity);
	}
	
	public void retrieveStudentActivity(String username, String studentName) {
		activity.setAdminName(username);
		activity.setDate_time(date());
		activity.setType("Retrieve Student");
		activity.setDescription("Retrieve Student " +studentName);
		activityRepository.save(activity);
	}
	
//Fee Activity Starts
	
	public void payFeeActivity(String username, String studentName, double amount) {
		activity.setAdminName(username);
		activity.setDate_time(date());
		activity.setType("Pay Fee");
		activity.setDescription("Pay fee of " +studentName +" Amount:" +amount);
		activityRepository.save(activity);
	}

}
