package com.learning.crmSystem.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learning.crmSystem.entity.CRMCustomer;

@Repository
@Transactional
public class CRMCustomerDAOImpl implements CRMCustomerDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public CRMCustomer fetchCustomer(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		System.out.println("calling fetchall using transaction with session "+session);
		return session.get(CRMCustomer.class, id);
	}

	
}
