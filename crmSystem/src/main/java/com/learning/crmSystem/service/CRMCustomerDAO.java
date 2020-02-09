package com.learning.crmSystem.service;


import com.learning.crmSystem.entity.CRMCustomer;

public interface CRMCustomerDAO {

	public CRMCustomer fetchCustomer(Integer id);
}
