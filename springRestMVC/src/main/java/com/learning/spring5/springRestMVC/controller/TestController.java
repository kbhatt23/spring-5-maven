package com.learning.spring5.springRestMVC.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.spring5.springRestMVC.exception.StudentNotFoundException;

@RestController
public class TestController {
	@RequestMapping("/testGenericException")
	public String testGenericException() {
		
		boolean kala= true;
		if(kala) {
			throw new StudentNotFoundException("test ke liye throw kara");
		}
		return "jai shree ram";
	}
}
