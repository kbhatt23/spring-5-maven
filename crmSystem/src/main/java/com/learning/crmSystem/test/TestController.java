package com.learning.crmSystem.test;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.learning.crmSystem.entity.CRMCustomer;
import com.learning.crmSystem.service.CRMCustomerDAO;
import com.learning.crmSystem.service.CRMCustomerDAOImpl;
import com.learning.crmSystem.service.CRMCustomerService;
import com.learning.crmSystem.service.CRMCustomerServiceImpl;

@Controller
public class TestController {

	@Autowired
	private CRMCustomerService service;
	
	@RequestMapping("/test")
	public String test() {
		System.out.println("test controller called");
		return "test";
	}
	
	@RequestMapping("/testHibernate")
	public String testHibernate(Model theModel) {

		theModel.addAttribute("customerList", service.fetchAllCustomers());
		return "show-customers";
	}
	
}
