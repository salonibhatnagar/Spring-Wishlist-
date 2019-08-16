package com.capgemini.storeserver.services;

import java.util.List;

import com.capgemini.storeserver.beans.Address;
import com.capgemini.storeserver.beans.Cart;
import com.capgemini.storeserver.beans.User1;
import com.capgemini.storeserver.beans.Product;
import com.capgemini.storeserver.exceptions.CustomerNotFoundException;
import com.capgemini.storeserver.exceptions.InvalidInputException;
import com.capgemini.storeserver.exceptions.ProductUnavailableException;

public interface CustomerServices {


	public boolean addProductToWishlist(int userId,int productId) throws InvalidInputException;

	public boolean removeProductFromWishlist(int userId,int productId) throws InvalidInputException;

	public List<Product> getWishlist(int userId) throws InvalidInputException;


	Cart addProductToNewCart(int userId,int productId, double amount) throws ProductUnavailableException;


}
