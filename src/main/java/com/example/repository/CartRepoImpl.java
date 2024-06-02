package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.model.Cart;
import com.example.model.Customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@Repository
public class CartRepoImpl implements CartRepo {

	@Autowired
	EntityManager eMan;

	@Override
	public List<Cart> getCarts() {

		return eMan.createQuery("from Cart").getResultList();
	}

	@Override
	public boolean addToCart(Cart cartRequest) {
		eMan.persist(cartRequest);

		return true;

	}

	@Override
	public boolean updateCart(Cart cart) {
		eMan.merge(cart);
		return true;
	}

	@Override
	public List<Cart> findCartByCustomerIds(Long customerId) {
		TypedQuery<Cart> qry = eMan.createQuery("From Cart c WHERE c.customer.customerId = :customerId", Cart.class);
		qry.setParameter("customerId", customerId);
		return qry.getResultList();
	}

	@Override
	public int deleteCart(Long customerId) {
		Query query = eMan.createQuery("DELETE FROM Cart c WHERE c.customer.customerId = :customerId");
		query.setParameter("customerId", customerId);

//        int deletedCount = 

		return query.executeUpdate();
	}

}
