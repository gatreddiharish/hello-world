package com.bofa.customer.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="account_type", schema="accountschema")
public class AccountType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2380843012137686017L;

	@Id
	@Column(name="account_type_id")
	private int accountTypeId;
	private String typeName;

	public AccountType() {
	}

	public AccountType(int accountTypeId, String typeName) {
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
