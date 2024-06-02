package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.model.Art;
import com.example.model.Cart;
//import com.example.service.CartService;
import com.example.service.CartServicee;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/rest/cart")
@CrossOrigin("http://localhost:3000")
public class CartController {

	@Autowired
	CartServicee cService;

//    public CartController() {
//		
//	}

	public CartController(CartServicee cService) {
		super();
		this.cService = cService;
	}

	@PutMapping("/updateCarts")
	public boolean doUpdate(@RequestBody Cart cart) {
		return cService.updateCart(cart);
	}

	@GetMapping("/getCarts")
	public Iterable<Cart> loadCarts() {
		return cService.getCarts();
	}

	@PostMapping("/add")
	public ResponseEntity<String> addToCart(@RequestBody Cart cartRequest) {
		try {
			cService.addToCart(cartRequest);
			return new ResponseEntity<>("Item added to cart successfully", HttpStatus.OK);
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>("An error occurred while adding item to cart",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getByCustomerId/{customerId}")
	public List<Cart> getByCustomerId(@PathVariable("customerId") Long customerId) {
		return cService.findCartByCustomerIds(customerId);
	}

	@DeleteMapping("/deleteCart/{customerId}")
	public int deleteCartByCustomerId(@PathVariable("customerId") Long customerId) {
		return cService.delteCart(customerId);
	}

}
