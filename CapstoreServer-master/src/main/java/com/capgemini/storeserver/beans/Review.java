package com.capgemini.storeserver.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Review {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int reviewId;
	//changed
	@ManyToOne
	@JoinColumn(name="productId")
	private Product product;//many to many ?????????
	private String comments;
	@ManyToOne
	@JoinColumn(name="phoneNumber")
	private User1 customer;//many to one
	private int productRating;
	
	
	public Review() {
		super();
	}
	public Review(Product product, String comments, User1 customer, int productRating) {
		super();
		this.product = product;
		this.comments = comments;
		this.customer = customer;
		this.productRating = productRating;
	}
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public User1 getCustomer() {
		return customer;
	}
	public void setCustomer(User1 customer) {
		this.customer = customer;
	}
	public int getProductRating() {
		return productRating;
	}
	public void setProductRating(int productRating) {
		this.productRating = productRating;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + reviewId;
		return result;
	}
	
	
	
}
