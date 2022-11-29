package com.jwt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwt.model.User;
import com.jwt.repositories.UserRepository;
import com.jwt.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	public UserRepository userRepository;

	@Override
	public String addUser(User user) {
		this.userRepository.save(user);

		return "User created successfully..!!";
	}

	@Override
	public User getUserByUserName(String userName) {

		User user = this.userRepository.findByUserName(userName);
		return user;
	}

}
