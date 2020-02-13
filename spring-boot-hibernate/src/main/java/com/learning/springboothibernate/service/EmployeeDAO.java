package com.learning.springboothibernate.service;

import java.util.List;

import com.learning.springboothibernate.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();
	
	public Employee findById(Integer id);
	
	public void save(Employee employee);
	
	public void update(Employee employee);
	
	public void delete(Integer id);
}
