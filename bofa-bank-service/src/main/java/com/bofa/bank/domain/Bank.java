package com.bofa.bank.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "bank", schema = "bankschema")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Bank implements Serializable {
	public Bank(int i, String name) {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -244485618592564474L;

	@Id
	private int bankId;
	private String name;
	private String description;
	private String merchantCode;
	private String tanNumber;

	@OneToOne(cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
	@JoinColumn(name="address_id")
	private Address address;

	
	@JsonManagedReference("bank-branch")
	@OneToMany(mappedBy = "bank",  cascade={CascadeType.ALL}, fetch = FetchType.LAZY)
	private List<Branch> branchList;

	@Override
	public int hashCode() {
		return Objects.hash(address, bankId, branchList, description, merchantCode, name, tanNumber);
	}
	


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bank other = (Bank) obj;
		return Objects.equals(address, other.address) && bankId == other.bankId
				&& Objects.equals(branchList, other.branchList) && Objects.equals(description, other.description)
				&& Objects.equals(merchantCode, other.merchantCode) && Objects.equals(name, other.name)
				&& Objects.equals(tanNumber, other.tanNumber);
	}

	

}
