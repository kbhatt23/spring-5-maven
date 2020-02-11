package com.learning.crmSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learning.crmSystem.entity.CRMCustomer;

@Service
public class CRMCustomerServiceImpl implements CRMCustomerService{

	@Autowired
	@Qualifier("CRMCustomerDAOImpl")
	private CRMCustomerDAO daoService;
	@Override
	@Transactional
	public CRMCustomer fetchCustomer(Integer id) {
		System.out.println("jai shree ganesh fetchCustomer "+id);
		return daoService.fetchCustomer(id);
	}
	@Override
	@Transactional
	public List<CRMCustomer> fetchAllCustomers() {
		System.out.println("jai shree ganesh fetchAllCustomers ");
		return daoService.fetchAllCustomers();
	}
	@Transactional
	@Override
	public void saveCustomer(CRMCustomer customer) {
		System.out.println("jai shree ganesh saveCustomer ");
		 daoService.saveCustomer(customer);
	}
	@Override
	@Transactional
	public void updateCustomer(CRMCustomer customer) {
		System.out.println("jai shree ganesh updateCustomer ");
		 daoService.updateCustomer(customer);
		
	}
	@Override
	@Transactional
	public void deleteCustomer(Integer id) {
		System.out.println("jai shree ganesh deletecustomer ");
		 daoService.deleteCustomer(id);
	}
	@Override
	@Transactional
	public List<CRMCustomer> searchCustomer(String customerSearchString) {
		// TODO Auto-generated method stub
		return daoService.searchCustomer(customerSearchString);
	}

}
