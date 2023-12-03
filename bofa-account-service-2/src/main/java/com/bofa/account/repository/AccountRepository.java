package com.bofa.account.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bofa.account.domain.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
	
	public List<Account> findByCustomerId(int customerId);
}
