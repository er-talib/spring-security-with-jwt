package com.jwt.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.model.User;
import com.jwt.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	
	@Autowired
	public UserService customUserService;
	@Autowired
	public BCryptPasswordEncoder bCryptPasswordEncoder;

	

	@PostMapping("/add")
	public ResponseEntity<?> addUser(@RequestBody User user) {
		user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
		user.setLoginDate(new Date());
		String addUser = this.customUserService.addUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(addUser);
	}
	
	@GetMapping("/get/{userName}")
	public ResponseEntity<?> getUser(@PathVariable String userName){
		User user = this.customUserService.getUserByUserName(userName);
		return ResponseEntity.ok(user);
	}

}
