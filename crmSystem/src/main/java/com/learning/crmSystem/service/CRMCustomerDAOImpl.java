package com.learning.crmSystem.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learning.crmSystem.entity.CRMCustomer;

@Repository
//removing transaction from here to service layer
//@Transactional
public class CRMCustomerDAOImpl implements CRMCustomerDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public CRMCustomer fetchCustomer(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		System.out.println("calling fetchall using transaction with session "+session);
		return session.get(CRMCustomer.class, id);
	}

	@Override
	public List<CRMCustomer> fetchAllCustomers() {
		Session session = sessionFactory.getCurrentSession();
		System.out.println("calling fetchall using transaction with session "+session);
		Query<CRMCustomer> queryAll = session.createQuery("from CRMCustomer order by lastName", CRMCustomer.class);
		return queryAll.getResultList();
		
	}

	@Override
	public void saveCustomer(CRMCustomer customer) {
		Session session = sessionFactory.getCurrentSession();
		System.out.println("calling saveCustomer using transaction with session "+session);
		session.save(customer);
	}

	@Override
	public void updateCustomer(CRMCustomer customer) {
		Session session = sessionFactory.getCurrentSession();
		System.out.println("calling update customer using transaction with session "+session);
		session.saveOrUpdate(customer);
	}

	@Override
	public void deleteCustomer(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		System.out.println("calling delete customer using transaction with session "+session + " with id "+id);
		CRMCustomer cusotmer = fetchCustomer(id);
		session.delete(cusotmer);
	}

	@Override
	public List<CRMCustomer> searchCustomer(String customerSearchString) {
		Session session = sessionFactory.getCurrentSession();
		System.out.println("calling search customer using transaction with session "+session + " with string "+customerSearchString);
		
		Query<CRMCustomer> searchQuery = session.createQuery("from CRMCustomer where lower(firstName) like :parseSearchString"
				+" or lower(lastName) like :parseSearchString"
				,CRMCustomer.class);
		searchQuery.setParameter("parseSearchString", "%"+customerSearchString.toLowerCase()+"%");
		
		List<CRMCustomer> searchList = searchQuery.getResultList();
		if(searchList == null || searchList.size() == 0) {
			Query<CRMCustomer> searchQueryAll = session.createQuery("from CRMCustomer" 
					,CRMCustomer.class);
			return searchQueryAll.getResultList();
		}else {
			return searchList;
		}
				
	}

	
}
