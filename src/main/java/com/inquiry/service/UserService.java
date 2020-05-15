package com.inquiry.service;

import java.util.List;

import com.inquiry.model.User;

public interface UserService {
	
	public User findByUsernameAndPassword(String username, String password);
	
	public User signUp(User user);
	
	public List<User> viewAllUser();

}
