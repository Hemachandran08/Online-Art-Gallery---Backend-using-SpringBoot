package com.example.service;

import java.util.List;

import com.example.model.Customer;

public interface CustomerService {
	
	public boolean addCustomer(Customer customer);
	
	public List<Customer> getCustomer();
	
	public boolean updateCustomer(Customer customer);
	
	public boolean validateLogIn(String logid, String pass);
	
	public Customer searchCustomer(Long customerId);

	public Customer findCustomer(Long customerId); 

}
