package com.inquiry.daoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inquiry.dao.UserDao;
import com.inquiry.model.User;
import com.inquiry.repository.UserRepository;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public User findByUsernameAndPassword(String username, String password) {
		return userRepository.findByUsernameAndPassword(username, password);
	}
	
	@Override
	public User signUp(User user) {
		User u = new User();
		try {
			u = userRepository.save(user);
		}catch(Exception e) {
			u = null;
		}
		return u;
	}

	@Override
	public List<User> viewAllUser() {
		return userRepository.findAll();
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public Optional<User> findById(int id) {
		return userRepository.findById(id);
	}

	@Override
	public void deleteById(int id) {
		userRepository.deleteById(id);
	}

	@Override
	public int countAllInquiry() {
		return userRepository.countAllInquiry();
	}

	@Override
	public int countPendingInquiry() {
		return userRepository.countPendingInquiry();
	}

	@Override
	public int countStudent() {
		return userRepository.countStudent();
	}

	@Override
	public int countPendingFees() {
		return userRepository.countPendingFees();
	}

}
