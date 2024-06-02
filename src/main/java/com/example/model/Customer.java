package com.example.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Customer {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long customerId;
	    private String customerName;
	    private String customerEmailID;
	    private String customerMobileNumber;	    
	    private String customerAddress;
	    private String customerPassword;
	    
	      
	    	    
//	    @OneToOne(mappedBy = "customer")
//	    @JoinColumn(name = "cart_id")
//	    private Cart cart;
	  

		public Customer() {
		
		}

		public Customer(Long customerId, String customerName, String customerPassword, String customerMobileNumber,
				String customerEmailID, String customerAddress) {
			super();
			this.customerId = customerId;
			this.customerName = customerName;
			this.customerPassword = customerPassword;
			this.customerMobileNumber = customerMobileNumber;
			this.customerEmailID = customerEmailID;
			this.customerAddress = customerAddress;
//			this.cart = cart;
			
		}

		public Long getCustomerId() {
			return customerId;
		}

		public void setCustomerId(Long customerId) {
			this.customerId = customerId;
		}

		public String getCustomerName() {
			return customerName;
		}

		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}

		public String getCustomerPassword() {
			return customerPassword;
		}

		public void setCustomerPassword(String customerPassword) {
			this.customerPassword = customerPassword;
		}

		public String getCustomerMobileNumber() {
			return customerMobileNumber;
		}

		public void setCustomerMobileNumber(String customerMobileNumber) {
			this.customerMobileNumber = customerMobileNumber;
		}

		public String getCustomerEmailID() {
			return customerEmailID;
		}

		public void setCustomerEmailID(String customerEmailID) {
			this.customerEmailID = customerEmailID;
		}

		public String getCustomerAddress() {
			return customerAddress;
		}

		public void setCustomerAddress(String customerAddress) {
			this.customerAddress = customerAddress;
		}

//		public Cart getCart() {
//			return cart;
//		}
//
//		public void setCart(Cart cart) {
//			this.cart = cart;
//		}
		
		
		


		
	    
}
