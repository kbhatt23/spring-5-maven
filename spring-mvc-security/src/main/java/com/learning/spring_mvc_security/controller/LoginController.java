package com.learning.spring_mvc_security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@GetMapping("/showLogin")
	public String showLogin() {
		return "login";
	}
	
	//landing page mapping
	@RequestMapping("/")
	public String landingPage() {
		return "landing";
	}
	
	//access denied page
	@RequestMapping("/access-denied")
	public String accessDeniedPAge(){
		
		return "access-denied";
	}
}
