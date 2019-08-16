package com.capgemini.storeserver.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int addressId;
	// changed
	@ManyToOne
	@JoinColumn(name = "phoneNumber")
	private User1 customer;// one to one
	private String country;
	private String state;
	private String city;
	private int zipcode;
	private String addressLine1;
	private String addressLine2;
	
	public Address() {
		super();
	}

	public Address(User1 customer, String country, String state, String city, int zipcode, String addressLine1,
			String addressLine2) {
		super();
		this.customer = customer;
		this.country = country;
		this.state = state;
		this.city = city;
		this.zipcode = zipcode;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
	}



	public User1 getCustomer() {
		return customer;
	}

	public void setCustomer(User1 customer) {
		this.customer = customer;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + addressId;
		return result;
	}



	
	
}
