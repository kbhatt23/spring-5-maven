package com.learning.springboothibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.springboothibernate.entity.Employee;
import com.learning.springboothibernate.service.EmployeeDAO;
import com.learning.springboothibernate.service.EmployeeJPARespository;

@RestController
public class TestController {

	@Autowired
	private EmployeeJPARespository repo;
	
	@Autowired
	@Qualifier("employeeDAOJPAImpl")
	private EmployeeDAO employeeHibernateDAO;
	
	@GetMapping("/test")
	public List<Employee> listAllEmployee(){
		return repo.findAll();
	}
	
	@GetMapping("/testHibernate")
	public List<Employee> listAllEmployeeHibernate(){
		return employeeHibernateDAO.findAll();
	}
}
