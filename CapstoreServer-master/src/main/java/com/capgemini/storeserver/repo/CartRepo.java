package com.capgemini.storeserver.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.storeserver.beans.Cart;
import com.capgemini.storeserver.beans.User1;



public interface CartRepo extends JpaRepository<Cart, Integer>{
	public Cart findByuser(User1 user);
}
