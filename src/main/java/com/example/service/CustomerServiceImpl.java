package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Customer;
import com.example.repository.CustomerRepo;


@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{

	
	@Autowired
	CustomerRepo cusRepo;
	
	@Override
	public boolean addCustomer(Customer customer) {
		return cusRepo.addCustomer(customer);
	}

	@Override
	public List<Customer> getCustomer() {
		return cusRepo.getCustomer();
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		return cusRepo.updateCustomer(customer);
	}

	@Override
	public boolean validateLogIn(String logid, String pass) {
		return cusRepo.validateLogin(logid, pass);
	}

	@Override
	public Customer searchCustomer(Long customerId) {
		
		return cusRepo.searchCustomers(customerId);
	}
	
	@Override
	public Customer findCustomer(Long customerId) {
		return cusRepo.findCustomer(customerId);
	}

}
