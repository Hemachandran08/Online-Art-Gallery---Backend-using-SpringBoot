package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Art;
import com.example.model.Cart;
import com.example.model.Customer;
import com.example.repository.CartRepo;

@Service
@Transactional
public class CartServiceImpl implements CartServicee {

	@Autowired
	CartRepo cRepo;

	@Autowired
	CustomerService cService;

	@Autowired
	ArtService artService;

	@Override
	public Iterable<Cart> getCarts() {
		return cRepo.getCarts();
	}

	@Override
	public boolean addToCart(Cart cartRequest) {
		if (cartRequest.getCustomer() == null || cartRequest.getArt() == null) {
			throw new IllegalArgumentException("Customer or product is null in the cart request.");
		}

		Long customerId = cartRequest.getCustomer().getCustomerId();
		Long artId = cartRequest.getArt().getArtId();
		int quantity = cartRequest.getQuantity();
		int totalPrice = cartRequest.getTotalPrice();

		Customer customer = cService.findCustomer(customerId);

		Art art = artService.findArt(artId);

		Cart cart = new Cart();
		cart.setCustomer(customer);
		cart.setArt(art);
		cart.setTotalPrice(totalPrice);
		cart.setQuantity(quantity);

		cRepo.addToCart(cart);
		return true;
	}

	@Override
	public boolean updateCart(Cart cart) {
		cRepo.updateCart(cart);
		return true;
	}

	@Override
	public List<Cart> findCartByCustomerIds(Long customerId) {
		return cRepo.findCartByCustomerIds(customerId);

	}

	@Override
	public int delteCart(Long cartId) {
		return cRepo.deleteCart(cartId);
	}

}
