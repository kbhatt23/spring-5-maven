package com.learning.crmSystem.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.learning.crmSystem.entity.CRMCustomer;

@Repository
public class FakeCustomerDAOImpl implements CRMCustomerDAO{

	@Override
	public CRMCustomer fetchCustomer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CRMCustomer> fetchAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveCustomer(CRMCustomer customer) {
		// TODO Auto-generated method stub
		
	}

}
