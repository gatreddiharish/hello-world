package com.bofa.transaction.model;

public class Deposit {

	private String accountNumber;
	private double amount;
	private String description;

	public Deposit() {

	}

	public Deposit(String accountNumber, double amount, String description) {
		super();
		this.accountNumber = accountNumber;
		this.amount = amount;
		this.description = description;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return "Deposit [accountNumber=" + accountNumber + ", amount=" + amount + ", description=" + description + "]";
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
