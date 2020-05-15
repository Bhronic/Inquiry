package com.inquiry.dao;

import java.util.List;

import com.inquiry.model.User;

public interface UserDao {
	
	public User findByUsernameAndPassword(String username, String password);
	
	public User signUp(User user);
	
	public List<User> viewAllUser();

}
