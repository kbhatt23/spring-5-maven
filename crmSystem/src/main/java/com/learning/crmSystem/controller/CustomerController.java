package com.learning.crmSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.learning.crmSystem.entity.CRMCustomer;
import com.learning.crmSystem.service.CRMCustomerService;


@Controller
@RequestMapping("/customer")
public class CustomerController {

	
	
	// need to inject our customer service
	@Autowired
	private CRMCustomerService customerService;
	
	@GetMapping("/test")
	public String test() {
		return "test";
	}
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		// get customers from the service
		List<CRMCustomer> theCustomers = customerService.fetchAllCustomers();
				
		// add the customers to the model
		theModel.addAttribute("customerList", theCustomers);
		
		return "show-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showCreateCustomerForm(Model theModel) {
		//empty model attribute
		CRMCustomer customer = new CRMCustomer();
		theModel.addAttribute("customerAttribute", customer);
		return "create-customer";
	}
	
	@PostMapping("/saveCustomer")
	public String createCustomer(@ModelAttribute("customerAttribute") CRMCustomer customer) {
		
		System.out.println(customer);
		customerService.saveCustomer(customer);
		//instead of jsp call the url directly
		return "redirect:/customer/list";
	}
	
}










