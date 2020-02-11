package com.learning.crmSystem.service;

import java.util.List;

import com.learning.crmSystem.entity.CRMCustomer;

public interface CRMCustomerService{

	public List<CRMCustomer> fetchAllCustomers();
	public CRMCustomer fetchCustomer(Integer id);
	public void saveCustomer(CRMCustomer customer);
	public void updateCustomer(CRMCustomer customer);
	public void deleteCustomer(Integer id);
}
