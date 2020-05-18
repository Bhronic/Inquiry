package com.inquiry.service;

import java.util.List;
import java.util.Optional;

import com.inquiry.model.User;

public interface UserService {
	
	public User findByUsernameAndPassword(String username, String password);
	
	public User signUp(User user);
	
	public List<User> viewAllUser();
	
	public User findByUsername(String username);
	
	public Optional<User> findById(int id);
	
	public void deleteById(int id);
	
	public int countAllInquiry();
	
	public int countPendingInquiry();
	
	public int countStudent();
	
	public int countPendingFees();

}
