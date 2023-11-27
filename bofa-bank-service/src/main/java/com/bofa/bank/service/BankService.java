package com.bofa.bank.service;

import com.bofa.bank.domain.Bank;

public interface BankService {
	
	public void createBank(Bank bank);
	
	public Bank findBankById(int bankId);
	
	public void deleteBank(int bankId);

}
