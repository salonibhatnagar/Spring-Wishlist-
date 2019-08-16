package com.capgemini.storeserver.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.storeserver.beans.User1;



public interface CustomerRepo extends JpaRepository<User1, Integer>{

	public User1 findByuserId(int userId);

}
