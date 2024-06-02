package com.example.repository;

import java.util.List;

import com.example.model.Customer;

public interface CustomerRepo 
{
	
	public boolean addCustomer(Customer customer);
	
	public List<Customer> getCustomer();
	
	public Customer findCustomer(Long customerId);
	
	public boolean updateCustomer(Customer customer);
	
	public boolean deleteCustomer(String customer);
	
	public Customer searchCustomers(Long customerId);

	boolean validateLogin(String logid, String pass);

	
}
