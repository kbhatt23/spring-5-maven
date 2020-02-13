package com.learning.springboothibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.springboothibernate.entity.Employee;
import com.learning.springboothibernate.service.EmployeeDAO;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeDAO employeeHibernateDAO;
	
	@GetMapping
	public List<Employee> fetchAllEmployee(){
		return employeeHibernateDAO.findAll();	
	}
	
	@GetMapping("/{id}")
	public Employee fetchEmployee(@PathVariable("id")int empid)
	{
		return employeeHibernateDAO.findById(empid);
	}
	
	@PostMapping
	public String createEmployee(@RequestBody Employee employee) {
		employeeHibernateDAO.save(employee);
		return "jai shree ram create";
	}
	
	@PutMapping
	public String updateEmployee(@RequestBody Employee employee) {
		employeeHibernateDAO.update(employee);
		return "jai shree ram update";
	}
	
	@DeleteMapping("/{id}")
	public String deleteEmployee(@PathVariable("id")int empid)
	{
		 employeeHibernateDAO.delete(empid);
		 return "jai shree ram delete";
	}
}
