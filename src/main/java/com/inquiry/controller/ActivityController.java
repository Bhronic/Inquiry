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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.inquiry.model.Activity;
import com.inquiry.service.ActivityService;

@Controller
public class ActivityController {
	
	@Autowired
	ActivityService activityService;
	
	@RequestMapping("ViewActivity")
	public ModelAndView viewActivity(HttpServletRequest request, HttpServletResponse response) {
		String uname = request.getParameter("admin");
		List<Activity> activityList = activityService.viewActivity(uname);
		request.setAttribute("activityList", activityList);
		return new ModelAndView("ViewActivity");
	}

//User Activity
	
	@RequestMapping("LoginActivity")
	public ModelAndView loginActivity(@RequestParam(name = "admin") String admin) {
		Activity activity = new Activity();
		Date dt1 = Calendar.getInstance().getTime(); 
		DateFormat dateFormat1 = new SimpleDateFormat("dd-MM-YYYY HH:mm:ss");
		String date1 = dateFormat1.format(dt1);
		activity.setAdminName(admin);
		activity.setDate_time(date1);
		activity.setType("SignIn");
		activityService.addActivity(activity);
		
		return new ModelAndView("redirect:index");
	}
	
	@RequestMapping("SignUpActivity")
	public ModelAndView signUpActivity(@RequestParam String uname) {
		Activity activity = new Activity();
		Date dt1 = Calendar.getInstance().getTime(); 
		DateFormat dateFormat1 = new SimpleDateFormat("dd-MM-YYYY HH:mm:ss");
		String date1 = dateFormat1.format(dt1);
		activity.setAdminName("jaymodi99");
		activity.setDate_time(date1);
		activity.setType("SignUp");
		activity.setDescription("New Admin " +uname);
		activityService.addActivity(activity);
		
		return new ModelAndView("redirect:index");
	}
	
	@RequestMapping("AdminDeleteActivity")
	public ModelAndView adminDeleteActivity(@RequestParam String uname) {
		Activity activity = new Activity();
		Date dt1 = Calendar.getInstance().getTime(); 
		DateFormat dateFormat1 = new SimpleDateFormat("dd-MM-YYYY HH:mm:ss");
		String date1 = dateFormat1.format(dt1);
		activity.setAdminName("jaymodi99");
		activity.setDate_time(date1);
		activity.setType("Delete Admin");
		activity.setDescription("Delete Admin " +uname);
		activityService.addActivity(activity);
		
		return new ModelAndView("redirect:Setting");
	}
	
//Inquiry Activity
	
	@RequestMapping("InquiryActivity")
	public ModelAndView inquiryActivity(@RequestParam String admin, @RequestParam String name) {
		Activity activity = new Activity();
		java.util.Date dt1 = Calendar.getInstance().getTime(); 
		DateFormat dateFormat1 = new SimpleDateFormat("dd-MM-YYYY HH:mm:ss");
		String date1 = dateFormat1.format(dt1);
		activity.setAdminName(admin);
		activity.setDate_time(date1);
		activity.setType("New Inquiry");
		activity.setDescription("New Inquiry " +name);
		activityService.addActivity(activity);
		
		return new ModelAndView("redirect:index");
	}
	
	@RequestMapping("InquiryEditActivity")
	public ModelAndView inquiryEditActivity(@RequestParam String admin, @RequestParam String name) {
		Activity activity = new Activity();
		java.util.Date dt1 = Calendar.getInstance().getTime(); 
		DateFormat dateFormat1 = new SimpleDateFormat("dd-MM-YYYY HH:mm:ss");
		String date1 = dateFormat1.format(dt1);
		activity.setAdminName(admin);
		activity.setDate_time(date1);
		activity.setType("Edit Inquiry");
		activity.setDescription("Edit Inquiry " +name);
		activityService.addActivity(activity);
		
		return new ModelAndView("redirect:ViewInquiry");
	}
	
	@RequestMapping("InquiryDeleteActivity")
	public ModelAndView inquiryDeleteActivity(@RequestParam String admin, @RequestParam String name) {
		Activity activity = new Activity();
		java.util.Date dt1 = Calendar.getInstance().getTime(); 
		DateFormat dateFormat1 = new SimpleDateFormat("dd-MM-YYYY HH:mm:ss");
		String date1 = dateFormat1.format(dt1);
		activity.setAdminName(admin);
		activity.setDate_time(date1);
		activity.setType("Delete Inquiry");
		activity.setDescription("Delete Inquiry " +name);
		activityService.addActivity(activity);
		
		return new ModelAndView("redirect:ViewInquiry");
	}
	
	@RequestMapping("InquiryRetriveActivity")
	public ModelAndView inquiryRetrieveActivity(@RequestParam String admin, @RequestParam String name) {
		Activity activity = new Activity();
		java.util.Date dt1 = Calendar.getInstance().getTime(); 
		DateFormat dateFormat1 = new SimpleDateFormat("dd-MM-YYYY HH:mm:ss");
		String date1 = dateFormat1.format(dt1);
		activity.setAdminName(admin);
		activity.setDate_time(date1);
		activity.setType("Retrieve Inquiry");
		activity.setDescription("Retrieve Inquiry " +name);
		activityService.addActivity(activity);
		
		return new ModelAndView("redirect:ViewInquiry");
	}
	
// Student Activity
	
	@RequestMapping("NewStudentActivity")
	public ModelAndView newStudentActivity(@RequestParam String admin, @RequestParam String name) {
		Activity activity = new Activity();
		java.util.Date dt1 = Calendar.getInstance().getTime(); 
		DateFormat dateFormat1 = new SimpleDateFormat("dd-MM-YYYY HH:mm:ss");
		String date1 = dateFormat1.format(dt1);
		activity.setAdminName(admin);
		activity.setDate_time(date1);
		activity.setType("New Student");
		activity.setDescription("New Student " +name);
		activityService.addActivity(activity);
		return new ModelAndView("redirect:ViewStudent");
	}
	
	@RequestMapping("StudentEditActivity")
	public ModelAndView studentEditActivity(@RequestParam String admin, @RequestParam String name) {
		Activity activity = new Activity();
		java.util.Date dt1 = Calendar.getInstance().getTime(); 
		DateFormat dateFormat1 = new SimpleDateFormat("dd-MM-YYYY HH:mm:ss");
		String date1 = dateFormat1.format(dt1);
		activity.setAdminName(admin);
		activity.setDate_time(date1);
		activity.setType("Edit Student");
		activity.setDescription("Edit Student " +name);
		activityService.addActivity(activity);
		return new ModelAndView("redirect:ViewStudent");
	}
	
	@RequestMapping("StudentDeleteActivity")
	public ModelAndView studentDeleteActivity(@RequestParam String admin, @RequestParam String name) {
		Activity activity = new Activity();
		java.util.Date dt1 = Calendar.getInstance().getTime(); 
		DateFormat dateFormat1 = new SimpleDateFormat("dd-MM-YYYY HH:mm:ss");
		String date1 = dateFormat1.format(dt1);
		activity.setAdminName(admin);
		activity.setDate_time(date1);
		activity.setType("Delete Student");
		activity.setDescription("Delete Student " +name);
		activityService.addActivity(activity);
		return new ModelAndView("redirect:ViewStudent");
	}
	
	@RequestMapping("StudentRetrieveActivity")
	public ModelAndView studentRetrieveActivity(@RequestParam String admin, @RequestParam String name) {
		Activity activity = new Activity();
		java.util.Date dt1 = Calendar.getInstance().getTime(); 
		DateFormat dateFormat1 = new SimpleDateFormat("dd-MM-YYYY HH:mm:ss");
		String date1 = dateFormat1.format(dt1);
		activity.setAdminName(admin);
		activity.setDate_time(date1);
		activity.setType("Retrieve Student");
		activity.setDescription("Retrieve Student " +name);
		activityService.addActivity(activity);
		return new ModelAndView("redirect:ViewStudent");
	}
	
	@RequestMapping("PayFeesActivity")
	public ModelAndView payFeesActivity(@RequestParam String admin, @RequestParam String name, @RequestParam Double amount) {
		Activity activity = new Activity();
		java.util.Date dt1 = Calendar.getInstance().getTime(); 
		DateFormat dateFormat1 = new SimpleDateFormat("dd-MM-YYYY HH:mm:ss");
		String date1 = dateFormat1.format(dt1);
		activity.setAdminName(admin);
		activity.setDate_time(date1);
		activity.setType("Pay Fee");
		activity.setDescription("Pay fee of " +name +" Amount:" +amount);
		activityService.addActivity(activity);
		return new ModelAndView("redirect:ViewStudent");
	}

}
