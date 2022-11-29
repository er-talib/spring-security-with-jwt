package com.jwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {
	
	@GetMapping("/success")
	public String homePage() {
		return "You have been login successfully..!!!";
	}

	@GetMapping("/test")
	public String signInPage() {
		return "This is test in page..!!";
	}
}
