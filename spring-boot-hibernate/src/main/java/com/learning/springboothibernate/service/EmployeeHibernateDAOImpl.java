package com.learning.springboothibernate.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.learning.springboothibernate.entity.Employee;

//repostiory can only be injected by reference of super interface only while autowiring
@Repository
public class EmployeeHibernateDAOImpl implements EmployeeDAO{
	
	private EntityManager entityManager;
	
	//constructor dependecny
	@Autowired
	public EmployeeHibernateDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	//no need of starting session transcation and commit
	@Transactional
	public List<Employee> findAll() {
	
		Session session = entityManager.unwrap(Session.class);
		Query<Employee> queryAll = session.createQuery("from Employee", Employee.class);
		return queryAll.getResultList();
	}

	@Override
	@Transactional
	public Employee findById(Integer id) {
		Session session = entityManager.unwrap(Session.class);
		return session.get(Employee.class, id);
	}

	@Override
	@Transactional
	public void save(Employee employee) {
		Session session = entityManager.unwrap(Session.class);
		session.save(employee);
	}

	@Override
	@Transactional
	public void update(Employee employee) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(employee);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		Session session = entityManager.unwrap(Session.class);
		session.delete(session.get(Employee.class, id));
		
	}

}
