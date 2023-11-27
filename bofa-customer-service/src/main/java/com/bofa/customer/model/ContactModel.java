
package com.bofa.customer.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ContactModel implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = -3616978090268294673L;

	private int contactId;
	private String type;
	private String value;

	@JsonIgnore
	private CustomerModel customer;

	public ContactModel() {

	}

	public ContactModel(int contactId, String type, String value, CustomerModel customer) {
		super();
		this.contactId = contactId;
		this.type = type;
		this.value = value;
		this.customer = customer;
	}

	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public CustomerModel getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerModel customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", type=" + type + ", value=" + value + ", customer=" + customer
				+ "]";
	}

}