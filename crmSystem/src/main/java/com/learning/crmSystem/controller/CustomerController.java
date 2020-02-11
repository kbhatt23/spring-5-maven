package com.learning.crmSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping("/showUpdateCustomer")
	public String showUpdateCustomer( @RequestParam("customerId") Integer customerId,Model theModel) {
		//populating the existing data
		CRMCustomer customer =  customerService.fetchCustomer(customerId);
		System.out.println("update se phle jai shree ram "+customer);
		theModel.addAttribute("customerAttribute", customer);
		return "show-update-customer";
	}
	
	@PostMapping("/updateCustomer")
	public String updateCustomer(@ModelAttribute("customerAttribute") CRMCustomer customer ) {
		System.out.println("jai shree ram from update cusomer "+customer);
		
		//call code to update the customer
		customerService.updateCustomer(customer);
		
		//instead of jsp call the url directly
				//we are using this so that we need not to populate the model again
				//this handles internally in the get mapping added here
		return "redirect:/customer/list";
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
		//we are using this so that we need not to populate the model again
		//this handles internally in the get mapping added here
		return "redirect:/customer/list";
	}
	
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") Integer customerId) {
		customerService.deleteCustomer(customerId);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/search")
	public String searchCustomer(@RequestParam("searchString") String customerSearchString , Model model) {
		System.out.println("jia shree ram from customer search "+customerSearchString);
		model.addAttribute("customerList",customerService.searchCustomer(customerSearchString));
		return "show-customers";
	}
	
}










