package com.inquiry.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.inquiry.model.User;
import com.inquiry.repository.InquiryRepository;
import com.inquiry.repository.StudentRepository;
import com.inquiry.repository.UserRepository;
import com.inquiry.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	@Autowired
	InquiryRepository inquiryRepository;
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	UserRepository userRepository;
	
	@PostMapping("/LoginController")
	public void loginController(HttpServletRequest request, HttpServletResponse response) {
		
		User user = new User();
		
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
    	
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
			
			int count1 = (int) inquiryRepository.count();
			int count2 = inquiryRepository.countByDel(0);
			int count3 = studentRepository.countByDel(0);
			int count4 = studentRepository.countPendingFees();
			session.setAttribute("count1", count1);
			session.setAttribute("count2", count2);
			session.setAttribute("count3", count3);
			session.setAttribute("count4", count4);
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
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session=request.getSession();  
		session.invalidate();
		
		return new ModelAndView("Login");
	}
	
	@RequestMapping("Profile")
	public ModelAndView viewProfile(HttpServletRequest request) {
		
		HttpSession session=request.getSession(false);  
		String username=(String)session.getAttribute("uname");
		User user = userRepository.findByUsername(username);
		
		request.setAttribute("user", user);
		
		return new ModelAndView("Profile");
	}
	
	@RequestMapping("Setting")
	public ModelAndView viewInquiry(HttpServletRequest request) {
		List<User> viewAllList = userService.viewAllUser();
		
		request.setAttribute("viewAllList", viewAllList);
		return new ModelAndView("Setting");
	}

}
