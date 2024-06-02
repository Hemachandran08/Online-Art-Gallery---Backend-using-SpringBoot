package com.example.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Customer;
import com.example.service.CustomerService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/rest/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		
		this.customerService = customerService;
	}

	public CustomerController() {
		}
	
	@PostMapping("/addCustomer")
	public boolean addCustomer(@RequestBody Customer customer) {
		return customerService.addCustomer(customer);
	}
	
	@PutMapping("/updateCustomer")
	public boolean updateCustomer(@RequestBody Customer customer) {
		return customerService.updateCustomer(customer);
	}
	
	@GetMapping("/getCustomer")
	public List<Customer> getCustomer(){
		return customerService.getCustomer();
	}
	
	@GetMapping("/getCustomerById/{customerId}")
	public Customer findCustomer(@PathVariable("customerId") Long customerId) {
		return customerService.findCustomer(customerId);
	}
	
	
}
