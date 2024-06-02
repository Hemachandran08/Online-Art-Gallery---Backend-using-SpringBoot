package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Cart;

public interface CartServicee {

	public Iterable<Cart> getCarts();

	public boolean addToCart(Cart cartRequest);

	public boolean updateCart(Cart cart);

	public List<Cart> findCartByCustomerIds(Long customerId);

	public int delteCart(Long customerId);

}
