package com.bofa.bank.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "branch", schema = "bankschema")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Branch implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3995688823390518140L;

	@Id
	private int branchId;
	private String name;
	private String ifscCode;

	@OneToOne(cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
	@JoinColumn(name="address_id")
	private Address address;

	@JsonBackReference("bank-branch")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "bank_id", nullable = false)
	private Bank bank;

	public Branch() {
	}

	public Branch(int branchId, String name, String ifscCode, Address address, Bank bank) {
		super();
		this.branchId = branchId;
		this.name = name;
		this.ifscCode = ifscCode;
		this.address = address;
		this.bank = bank;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	@Override
	public String toString() {
		return "Branch [branchId=" + branchId + ", name=" + name + ", ifscCode=" + ifscCode + ", address=" + address
				+ ", bank=" + bank + ", getBranchId()=" + getBranchId() + ", getName()=" + getName()
				+ ", getIfscCode()=" + getIfscCode() + ", getAddress()=" + getAddress() + ", getBank()=" + getBank()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
