package com.bofa.account.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="account", schema="accountschema")
public class Account implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2185106353061473176L;

	@Id
	@Column(name="account_number")
	private String accountNumber;
	
	private String description;
	private double balance;
	private String status;
	private Date createdDate;
	private int customerId;

	@OneToOne
	@JoinColumn(name="account_type_id")
	private AccountType accountType;

	public Account() {
	}

	public Account(String accountNumber, String description, double balance, String status, Date createdDate,
			int customerId, AccountType accountType) {
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

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", description=" + description + ", balance=" + balance
				+ ", status=" + status + ", createdDate=" + createdDate + ", customerId=" + customerId
				+ ", accountType=" + accountType + "]";
	}

}
