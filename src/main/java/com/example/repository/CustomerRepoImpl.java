package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.model.Customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;

@Repository
public class CustomerRepoImpl implements CustomerRepo{
	
	
	@Autowired
	EntityManager eMan;

	@Override
	public boolean addCustomer(Customer customer) {
		eMan.persist(customer);
		return true;
	}

	@Override
	public List<Customer> getCustomer() {
		return eMan.createQuery("from Customer").getResultList();
	}

	@Override
	public Customer findCustomer(Long customerId) {
		Customer cus = eMan.find(Customer.class, customerId);
		return cus;
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		eMan.merge(customer);
		return true;
	}

	@Override
	public boolean deleteCustomer(String customer) {
		Customer cus1 = eMan.find(Customer.class, customer);
		eMan.remove(cus1);
		return true;
	}

	@Override
	public Customer searchCustomers(Long customerId) {
		Query qry = eMan.createQuery("from Customer c where c.customerId=?1");
		qry.setParameter(1, customerId);
		return (Customer) qry.getSingleResult();
	}
	
	@Override
	public boolean validateLogin(String logid, String pass) {
		Query qry2 = eMan.createQuery("from Customer log where log.customerId =?1 and log.customerPassword=?2");
		qry2.setParameter(1, logid);
		qry2.setParameter(2, pass);

		List<Customer> users = qry2.getResultList();
		if (users.size() > 0)
			return true;
		else
			return false;
	}
	
	

	
}
