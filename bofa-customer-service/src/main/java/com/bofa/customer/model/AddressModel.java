
package com.bofa.customer.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class AddressModel implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 7789282250432002834L;

	private int addressId;
	private String street;
	private String city;
	private String state;
	private String zipCode;
	
	@JsonIgnore
	private CustomerModel customer;

	public AddressModel() {

	}

	public AddressModel(int addressId, String street, String city, String state, String zipCode,
			CustomerModel customer) {
		super();
		this.addressId = addressId;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.customer = customer;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public CustomerModel getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerModel customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", street=" + street + ", city=" + city + ", state=" + state
				+ ", zipCode=" + zipCode + ", customer=" + customer + "]";
	}

}