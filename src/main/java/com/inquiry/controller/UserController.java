package com.inquiry.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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

import com.inquiry.model.Activity;
import com.inquiry.model.User;
import com.inquiry.repository.ActivityRepository;
import com.inquiry.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	@Autowired
	ActivityRepository activityRepository;
	
	@PostMapping("/LoginController")
	public void loginController(HttpServletRequest request, HttpServletResponse response) {
		
		User user = new User();
		
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
    	
//Finds User from Database
    	User u = userService.findByUsernameAndPassword(user.getUsername(), user.getPassword());

		if(u != null)
		{
			HttpSession session = request.getSession();
			session.setAttribute("uname", user.getUsername());
			try {
				response.sendRedirect("index");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		Activity activity = new Activity();
		Date dt1 = Calendar.getInstance().getTime(); 
		DateFormat dateFormat1 = new SimpleDateFormat("dd-MM-YYYY HH:mm:ss");
		String date1 = dateFormat1.format(dt1);
		activity.setAdminName(user.getUsername());
		activity.setDate_time(date1);
		activity.setType("SignIn");
		activityRepository.save(activity);
			
	/*Index Count Starts*/
			int count1 = userService.countAllInquiry();
			int count2 = userService.countPendingInquiry();
			int count3 = userService.countStudent();
			int count4 = userService.countPendingFees();
			session.setAttribute("count1", count1);
			session.setAttribute("count2", count2);
			session.setAttribute("count3", count3);
			session.setAttribute("count4", count4);
	/*!Index Count Ends*/
		}
		else
		{
			try {
				response.sendRedirect("Login");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@PostMapping("/SignUpController")
	public void signUpController(HttpServletRequest request, HttpServletResponse response) {
		User user = new User();
		
		user.setFname(request.getParameter("firstname"));
		user.setLname(request.getParameter("lastname"));
		user.setEmail(request.getParameter("email"));
		user.setGender(request.getParameter("gender"));
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
    	
		User u = userService.signUp(user);
		if(u != null) {

			Activity activity = new Activity();
			Date dt1 = Calendar.getInstance().getTime(); 
			DateFormat dateFormat1 = new SimpleDateFormat("dd-MM-YYYY HH:mm:ss");
			String date1 = dateFormat1.format(dt1);
			activity.setAdminName("jaymodi99");
			activity.setDate_time(date1);
			activity.setType("SignUp");
			activity.setDescription("New Admin " +user.getUsername());
			activityRepository.save(activity);
			
			try {
				response.sendRedirect("index");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
			try {
				response.sendRedirect("SignUp");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@RequestMapping("/LogoutController")
	public void logout(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session=request.getSession();  
		session.invalidate();
		
		try {
			response.sendRedirect("Login");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("Profile")
	public ModelAndView viewProfile(HttpServletRequest request) {
		
		HttpSession session=request.getSession(false);  
		String username=(String)session.getAttribute("uname");
		User user = userService.findByUsername(username);
		
		request.setAttribute("user", user);
		
		return new ModelAndView("Profile");
	}
	
	@RequestMapping("Setting")
	public ModelAndView viewInquiry(HttpServletRequest request) {
		List<User> viewAllList = userService.viewAllUser();
		
		request.setAttribute("viewAllList", viewAllList);
		return new ModelAndView("Setting");
	}
	
	@RequestMapping("AdminDeleteController")
	public void deleteUser(HttpServletRequest request, HttpServletResponse response) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		Optional<User> u = userService.findById(id);
		userService.deleteById(id);
		
		Activity activity = new Activity();
		Date dt1 = Calendar.getInstance().getTime(); 
		DateFormat dateFormat1 = new SimpleDateFormat("dd-MM-YYYY HH:mm:ss");
		String date1 = dateFormat1.format(dt1);
		activity.setAdminName("jaymodi99");
		activity.setDate_time(date1);
		activity.setType("Delete Admin");
		activity.setDescription("Delete Admin " +u.get().getUsername());
		activityRepository.save(activity);
		
		try {
			response.sendRedirect("Setting");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
