package com.capgemini.storeserver.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.storeserver.beans.Address;
import com.capgemini.storeserver.beans.Cart;

import com.capgemini.storeserver.beans.User1;
import com.capgemini.storeserver.beans.User2;
import com.capgemini.storeserver.beans.User3;
import com.capgemini.storeserver.beans.User4;
import com.capgemini.storeserver.beans.Product;
import com.capgemini.storeserver.exceptions.CustomerNotFoundException;
import com.capgemini.storeserver.exceptions.InvalidInputException;
import com.capgemini.storeserver.services.CustomerServices;

@RestController
public class CustomerActionController {

	

	@Autowired
	private CustomerServices customerService;
	//aksh
	@PutMapping(value= "/getWishlist",consumes= {"application/json"})
	public List<Product> getWishlist(@RequestBody User2 user2) {
		 List<Product> wishList=null;
		try {
			wishList = customerService.getWishlist(user2.getUserId());
		} catch (InvalidInputException e) {
			return wishList;
		}
		
		return wishList;
	}

	@PostMapping(value= "/new",consumes= {"application/json"})
	public boolean addProductToWishlist(@RequestBody User3 user3) {
		boolean val;
		try {
			 val=customerService.addProductToWishlist(User3.getUserId(),User3.getProductId());
		} catch (InvalidInputException e) {
			return false;
		}
		
		return val;
	}

	@PostMapping(value= "/remove",consumes= {"application/json"})
	public boolean removeProductFromWishlist(@RequestBody User3 u) {
		boolean val;
		try {
			val=customerService.removeProductFromWishlist(u.getUserId(),u.getProductId());
		} catch (InvalidInputException e) {
			return false;
		}
		
		return val;
	}


	
//	@RequestMapping(value= "/addProductToNewCart")
//	public Cart addProductToNewCart(int userId,int quantity, int productId) { 
//		Cart cart=null;
//		try {
//			cart= customerService.addProductToNewCart(userId, productId, quantity);
//		}
//		catch  (Exception e) {
//			return cart;
//		}
//		return cart;
//	}

	
	@PostMapping(value= "/addProductToNewCart/create", consumes= {"application/json"})
	 public Cart addProductToNewCart(@RequestBody User4 user4) {
	 Cart cart=null;
	 try {
	  cart= customerService.addProductToNewCart(user4.getUserId(),user4.getProductId(),user4.getAmount());
	 }
	 catch (Exception e) {
	  return cart;
	 }
	 return cart;
	 }
}
