package com.bofa.transaction.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.bofa.transaction.domain.Transaction;
import com.bofa.transaction.model.Account;

public interface TransactionService {
	
	public void createTransaction(Transaction transaction);
	
	public Transaction findByTransactionId(int transactionId);
	
	public List<Transaction> findAllTransactions();
	
	public List<Transaction> findTransactionByDate(Date date);
	
	public List<Transaction> findTransactionsBetweenDates(Date toDate, Date fromDate);
	
	public Account deposit(Account account, double amount);
	
	public HashMap<?, ?> withdrawal(Account account, double amount);
	
	public HashMap<String, Account> transfer(Account fromAccount, Account toAccount, double amount);
	

}
