package com.jwt.service;

import com.jwt.model.User;

public interface UserService {
	
	public String addUser(User user);
	public User getUserByUserName(String userName );

}
