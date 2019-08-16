package com.capgemini.storeserver.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.storeserver.beans.Address;
import com.capgemini.storeserver.beans.Cart;
import com.capgemini.storeserver.beans.User1;
import com.capgemini.storeserver.beans.Product;
import com.capgemini.storeserver.beans.Review;
import com.capgemini.storeserver.beans.Wishlist;
import com.capgemini.storeserver.exceptions.CustomerNotFoundException;
import com.capgemini.storeserver.exceptions.InvalidInputException;
import com.capgemini.storeserver.exceptions.ProductUnavailableException;
import com.capgemini.storeserver.repo.AddressRepo;
import com.capgemini.storeserver.repo.CartRepo;
import com.capgemini.storeserver.repo.CustomerRepo;
import com.capgemini.storeserver.repo.ProductRepo;
import com.capgemini.storeserver.repo.WishlistRepo;

@Service(value = "customerServices")
public class CustomerServicesImpl implements CustomerServices {

	User1 user;
	Review review;
	Product product;

	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	private CartRepo cartRepo;

	@Autowired
	private AddressRepo addressRepo;

	@Autowired
	private WishlistRepo wishlistRepo;

	@Autowired
	private ProductRepo productRepo;

	

	@Override
	public boolean addProductToWishlist(int userId, int productId) throws InvalidInputException {
		product = productRepo.getOne(productId);
		user = customerRepo.findByuserId(userId);
		Wishlist wishlist = wishlistRepo.findByuser(user);
		//if (wishlist == null) {
			wishlist = new Wishlist();
			//product.setWishlist(wishlist);
//			List<User1> list=new ArrayList<User1>();
//			list.add(user);
			wishlist.setUser(user);
			List<Product> productsList = new ArrayList<Product>();
			productsList.add(product);
			wishlist.setProducts(productsList);
			
			Wishlist w=new Wishlist(user,productsList,"First List");
			wishlistRepo.save(w);

//		} else {
//			product.setWishlist(wishlist);
//			List<Product> productsList = wishlist.getProducts();
//			productsList.add(product);
//			wishlist.setProducts(productsList);
//			wishlistRepo.save(wishlist);

		return true;
	}

	@Override
	public boolean removeProductFromWishlist(int userId, int productId) throws InvalidInputException {
		product = productRepo.getOne(productId);
		user = customerRepo.findByuserId(userId);
		Wishlist wishlist = wishlistRepo.findByuser(user);
		List<Product> productsList = wishlist.getProducts();
		productsList.remove(product);
		wishlist.setProducts(productsList);
		//Wishlist w=new Wishlist();
		//product.setWishlist(null);
		wishlistRepo.save(wishlist);
		return true;
	}

	@Override
	public List<Product> getWishlist(int userId) throws InvalidInputException {
		Wishlist wishlist = new Wishlist();
		try {
			user = customerRepo.findByuserId(userId);
			wishlist = wishlistRepo.findByuser(user);
		} catch (Exception e) {
			e.getMessage();
		}
		return wishlist.getProducts();
	}


	@Override
	public Cart addProductToNewCart(int userId, int productId, double amount)
			throws ProductUnavailableException {
//		product = productRepo.getOne(productId);
//		String error = "This quantity of the product is not available";
//		if (product.getQuantity() > quantity) {
//			Cart cart = new Cart();
//			List<Product> products = new ArrayList<Product>();
//			//product.setCartQuantity(quantity);
//			products.add(product);
//			double productPrice = product.getPrice();
//			double amount = productPrice * quantity;
//			cart.setAmount(amount);
//			cart.setProducts(products);
//			cart.setUser(customerRepo.getOne(userId));
//			return cartRepo.save(cart);
		 product = productRepo.getOne(productId);
		  user =customerRepo.getOne(userId);
		  Cart cart = new Cart();
		  List<Product> products = new ArrayList<Product>();
		  products.add(product);
		  cart.setUser(customerRepo.getOne(userId));
		  cart.setProducts(products);
		  cart.setAmount(amount);
		  return cartRepo.save(cart);


	}
}


