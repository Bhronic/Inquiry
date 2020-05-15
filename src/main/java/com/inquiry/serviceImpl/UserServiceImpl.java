package com.inquiry.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inquiry.dao.UserDao;
import com.inquiry.model.User;
import com.inquiry.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;

	@Override
	public User findByUsernameAndPassword(String username, String password) {
		return userDao.findByUsernameAndPassword(username, password);
	}
	
	public User signUp(User user) {
		return userDao.signUp(user);
	}

	@Override
	public List<User> viewAllUser() {
		return userDao.viewAllUser();
	}

}
