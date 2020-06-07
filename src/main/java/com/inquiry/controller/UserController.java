package com.inquiry.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.inquiry.model.User;
import com.inquiry.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/LoginController")
	public ModelAndView loginController(@ModelAttribute("user") User user, HttpServletRequest request) {
    	
		ModelAndView mv = null;
//Finds User from Database
    	User u = userService.findByUsernameAndPassword(user.getUsername(), user.getPassword());

		if(u != null)
		{
			HttpSession session = request.getSession();
			session.setAttribute("uname", user.getUsername());
			
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
			mv = new ModelAndView("redirect:/LoginActivity?admin=" +user.getUsername());
		}
		else
		{
			mv = new ModelAndView("redirect:Login");
		}
		return mv;
	}
	
	@PostMapping("/SignUpController")
	public ModelAndView signUpController(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("user") User user) {
    	
		ModelAndView mv = null;
		User u = userService.signUp(user);
		if(u != null) {
			mv = new ModelAndView("redirect:SignUpActivity?uname=" +user.getUsername());
		}
		else {
			mv = new ModelAndView("redirect:SignUp");
		}
		return mv;
	}
	
	@RequestMapping("/LogoutController")
	public ModelAndView logout(HttpServletRequest request) {
		
		HttpSession session=request.getSession();  
		session.invalidate();
	
		return new ModelAndView("redirect:Login");
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
	public ModelAndView deleteUser(@RequestParam("id") int id) {
		
		Optional<User> u = userService.findById(id);
		userService.deleteById(id);

		return new ModelAndView("redirect:AdminDeleteActivity?uname=" +u.get().getUsername());
	}

}
