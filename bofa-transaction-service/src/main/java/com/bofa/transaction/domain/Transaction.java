package com.bofa.transaction.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transaction", schema="transactionschema")
public class Transaction implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9021018452561012862L;
	
	@Id
	@Column(name="transaction_id")
	private int transactionId;
	private String description;
	private Date transactionDate;
	private String type;
	private int customerId;
	private String fromAccount;
	private String toAccount;
	private double amount;
	
	public Transaction() {
		
	}

	public Transaction(int transactionId, String description, Date transactionDate, String type, int customerId,
			String fromAccount, String toAccount, double amount) {
		super();
		this.transactionId = transactionId;
		this.description = description;
		this.transactionDate = transactionDate;
		this.type = type;
		this.customerId = customerId;
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.amount = amount;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(String fromAccount) {
		this.fromAccount = fromAccount;
	}

	public String getToAccount() {
		return toAccount;
	}

	public void setToAccount(String toAccount) {
		this.toAccount = toAccount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", description=" + description + ", transactionDate="
				+ transactionDate + ", type=" + type + ", customerId=" + customerId + ", fromAccount=" + fromAccount
				+ ", toAccount=" + toAccount + ", amount=" + amount + "]";
	}

}
