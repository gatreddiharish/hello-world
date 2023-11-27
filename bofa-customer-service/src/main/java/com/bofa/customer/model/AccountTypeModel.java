package com.bofa.customer.model;

import java.io.Serializable;


public class AccountTypeModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2380843012137686017L;

	private int accountTypeId;
	private String typeName;

	public AccountTypeModel() {
	}

	public AccountTypeModel(int accountTypeId, String typeName) {
		super();
		this.accountTypeId = accountTypeId;
		this.typeName = typeName;
	}

	public int getAccountTypeId() {
		return accountTypeId;
	}

	public void setAccountTypeId(int accountTypeId) {
		this.accountTypeId = accountTypeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "AccountType [accountTypeId=" + accountTypeId + ", typeName=" + typeName + "]";
	}

}
