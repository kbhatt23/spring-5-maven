package com.learning.crmSystem.test;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import com.learning.crmSystem.entity.CRMCustomer;

@Controller
public class TestController {

	@Autowired
	private SessionFactory sessionFactory;
	
	@RequestMapping("/test")
	public String test() {
		System.out.println("test controller called");
		return "test";
	}
	
	@RequestMapping("/testHibernate")
	public String testHibernate() {
		System.out.println("testHibernate controller called");
		System.out.println(listACustomer());
		return "testHibernate";
	}
	
	//we can remove this transaction and test
	//@Transactional
	   public CRMCustomer listACustomer() {
		   Session session = sessionFactory.getCurrentSession();
		   CRMCustomer customer = null;
		   try {
		 
		   session.beginTransaction();
		   customer = session.get(CRMCustomer.class, 10);
		   }finally {
			session.getTransaction().commit();
		}
		   return customer;
	   }
}
