package com.capgemini.storeserver.beans;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.boot.context.properties.EnableConfigurationProperties;

@Entity
@Table(name="cart")
public class Cart {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer cartId;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="User1.userId")
	private User1 user;
	
	@ElementCollection
	private List<Product> products;
	
	@Column
	private Double amount;
	
	public Cart() {
		// TODO Auto-generated constructor stub
	}

	public Cart(User1 user, List<Product> products, Double amount) {
		super();
		this.user = user;
		this.products = products;
		this.amount = amount;
	}

	public User1 getUser() {
		return user;
	}

	public void setUser(User1 user) {
		this.user = user;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> product) {
		this.products = product;
	}
	
	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	

}