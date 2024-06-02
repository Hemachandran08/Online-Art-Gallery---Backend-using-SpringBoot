package com.example.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.model.Cart;


public interface CartRepo {

	public Iterable<Cart> getCarts();
	
	public boolean addToCart(Cart cartRequest);
	
	public boolean updateCart(Cart cart);
	
	public List<Cart> findCartByCustomerIds(Long customerId);

	int deleteCart(Long customerId);
}
