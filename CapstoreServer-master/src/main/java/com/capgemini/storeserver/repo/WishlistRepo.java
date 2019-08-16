package com.capgemini.storeserver.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.capgemini.storeserver.beans.User1;
import com.capgemini.storeserver.beans.Wishlist;

public interface WishlistRepo extends JpaRepository<Wishlist, Integer>,CrudRepository<Wishlist, Integer>{

	public Wishlist findByuser(User1 user);
}
