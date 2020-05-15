package com.inquiry.daoImpl;

import java.util.List;

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

}
