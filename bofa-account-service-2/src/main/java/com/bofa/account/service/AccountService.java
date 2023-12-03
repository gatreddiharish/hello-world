package com.bofa.account.service;

import java.util.List;

import com.bofa.account.domain.Account;

public interface AccountService {
	
	public void createAccount(Account account);
	
	public List<Account> findAccountsByCustomer(int customerId);
	
	public Account findByAccountNumber(String accountNumber);

}
