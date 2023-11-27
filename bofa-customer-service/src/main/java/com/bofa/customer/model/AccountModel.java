package com.bofa.customer.model;

import java.io.Serializable;
import java.util.Date;

public class AccountModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2185106353061473176L;

	private String accountNumber;

	private String description;
	private double balance;
	private String status;
	private Date createdDate;
	private int customerId;

	private AccountTypeModel accountType;

	public AccountModel() {
	}

	public AccountModel(String accountNumber, String description, double balance, String status, Date createdDate,
			int customerId, AccountTypeModel accountType) {
		super();
		this.accountNumber = accountNumber;
		this.description = description;
		this.balance = balance;
		this.status = status;
		this.createdDate = createdDate;
		this.customerId = customerId;
		this.accountType = accountType;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public AccountTypeModel getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountTypeModel accountType) {
		this.accountType = accountType;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", description=" + description + ", balance=" + balance
				+ ", status=" + status + ", createdDate=" + createdDate + ", customerId=" + customerId
				+ ", accountType=" + accountType + "]";
	}

}
