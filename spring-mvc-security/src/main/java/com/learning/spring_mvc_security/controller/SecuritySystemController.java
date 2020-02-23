package com.learning.spring_mvc_security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/security-system")
public class SecuritySystemController {

	@RequestMapping
	public String home() {
		return "home";
	}
	
	@RequestMapping("/managers")
	public String showManagersSection()
	{
		return "managers";
	}
	
	@RequestMapping("/admins")
	public String showAdminSections()
	{
		return "admins";
	}
	
	
	
}
