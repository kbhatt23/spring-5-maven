package com.learning.crmSystemRest.service;


import java.util.List;

import com.learning.crmSystemRest.entity.CRMCustomer;

public interface CRMCustomerDAO {

	public List<CRMCustomer> fetchAllCustomers();
	
	public CRMCustomer fetchCustomer(Integer id);
	
	public void saveCustomer(CRMCustomer customer);
	
	public void updateCustomer(CRMCustomer customer);
	
	public void deleteCustomer(Integer id);
	
	public List<CRMCustomer> searchCustomer(String customerSearchString);
}
