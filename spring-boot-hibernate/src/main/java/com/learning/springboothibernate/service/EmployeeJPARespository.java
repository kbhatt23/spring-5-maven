package com.learning.springboothibernate.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.springboothibernate.entity.Employee;
@Repository
public interface EmployeeJPARespository extends JpaRepository<Employee, Integer>{

}
