package com.learning.crmSystemRest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.crmSystemRest.entity.CRMCustomer;
import com.learning.crmSystemRest.service.CRMCustomerService;


@RestController
public class TestController {
	@Autowired
	private CRMCustomerService customerService;

	@GetMapping("/test")
	public String test() {
		String mes = "jai shree ram from test";
		System.out.println(mes);
		return mes;
	}
	
	@GetMapping("/list")
	public List<CRMCustomer>listCustomers() {
		
		// get customers from the service
		return  customerService.fetchAllCustomers();
				
		
	}
}
