package com.inquiry.serviceImpl;

import java.util.List;
import java.util.Optional;

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

	@Override
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

	@Override
	public Optional<User> findById(int id) {
		return userDao.findById(id);
	}

	@Override
	public void deleteById(int id) {
		userDao.deleteById(id);
	}

	@Override
	public int countAllInquiry() {
		return userDao.countAllInquiry();
	}

	@Override
	public int countPendingInquiry() {
		return userDao.countPendingInquiry();
	}

	@Override
	public int countStudent() {
		return userDao.countStudent();
	}

	@Override
	public int countPendingFees() {
		return userDao.countPendingFees();
	}

}
