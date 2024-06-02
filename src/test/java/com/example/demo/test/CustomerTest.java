package com.example.demo.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.model.Customer;
import com.example.service.CustomerService;


@SpringBootTest
class CustomerTest {

	
	@Autowired
	CustomerService cService;
	
	
	@Test
	void testGetCustomer() {
		assertNotNull(cService.getCustomer());
	}	
	
	
}
