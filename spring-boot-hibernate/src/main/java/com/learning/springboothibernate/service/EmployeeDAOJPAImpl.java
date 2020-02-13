package com.learning.springboothibernate.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.learning.springboothibernate.entity.Employee;
@Transactional
@Repository
public class EmployeeDAOJPAImpl implements EmployeeDAO{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Employee> findAll() {
		System.out.println("jai shree ram from jpa style");
		TypedQuery<Employee> selectQuery = entityManager.createQuery("select A from Employee A", Employee.class);
		return selectQuery.getResultList();
	}

	@Override
	public Employee findById(Integer id) {
		System.out.println("jai shree ram from jpa style");
		return entityManager.find(Employee.class, id);
	}

	@Override
	public void save(Employee employee) {
		System.out.println("jai shree ram from jpa style");
		entityManager.merge(employee);		
	}

	@Override
	public void update(Employee employee) {
		System.out.println("jai shree ram from jpa style");

		entityManager.persist(employee);
	}

	@Override
	public void delete(Integer id) {
		System.out.println("jai shree ram from jpa style");
		entityManager.remove(entityManager.find(Employee.class, id));
	}

}
