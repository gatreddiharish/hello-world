package com.bofa.customer.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class CustomerModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7781898955041396617L;

	private int customerId;

	private String firstName;

	private String lastName;

	private String middleName;

	private String adharNumber;

	private String panNumber;

	private Date dateOfBirth;

	private String gender;

	private String martialStatus;

	private List<AddressModel> addresses;

	private List<ContactModel> contacts;

	private List<AccountModel> accountList;

	public CustomerModel() {

	}

	public CustomerModel(int customerId, String firstName, String lastName, String middleName, String adharNumber,
			String panNumber, Date dateOfBirth, String gender, String martialStatus, List<AddressModel> addresses,
			List<ContactModel> contacts, List<AccountModel> accountList) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.adharNumber = adharNumber;
		this.panNumber = panNumber;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.martialStatus = martialStatus;
		this.addresses = addresses;
		this.contacts = contacts;
		this.accountList = accountList;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getAdharNumber() {
		return adharNumber;
	}

	public void setAdharNumber(String adharNumber) {
		this.adharNumber = adharNumber;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMartialStatus() {
		return martialStatus;
	}

	public void setMartialStatus(String martialStatus) {
		this.martialStatus = martialStatus;
	}

	public List<AddressModel> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<AddressModel> addresses) {
		this.addresses = addresses;
	}

	public List<ContactModel> getContacts() {
		return contacts;
	}

	public void setContacts(List<ContactModel> contacts) {
		this.contacts = contacts;
	}

	public List<AccountModel> getAccountList() {
		return accountList;
	}

	public void setAccountList(List<AccountModel> accountList) {
		this.accountList = accountList;
	}

	@Override
	public String toString() {
		return "CustomerModel [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", middleName=" + middleName + ", adharNumber=" + adharNumber + ", panNumber=" + panNumber
				+ ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", martialStatus=" + martialStatus
				+ ", addresses=" + addresses + ", contacts=" + contacts + ", accountList=" + accountList + "]";
	}

}