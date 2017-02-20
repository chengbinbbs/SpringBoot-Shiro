package com.daysluck.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daysluck.dao.UserRepository;
import com.daysluck.domain.User;
import com.daysluck.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	private UserRepository userRepository;
	
	public User findByUsername(String username) {
		
		return userRepository.findByUsername(username);
	}

}
