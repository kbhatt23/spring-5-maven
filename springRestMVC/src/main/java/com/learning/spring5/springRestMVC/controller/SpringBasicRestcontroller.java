package com.learning.spring5.springRestMVC.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringBasicRestcontroller {

	@RequestMapping("/test")
	public String test() {
		return "jai shree ram";
	}
}
