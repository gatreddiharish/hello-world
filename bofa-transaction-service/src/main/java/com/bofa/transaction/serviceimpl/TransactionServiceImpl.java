package com.bofa.transaction.serviceimpl;



import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bofa.transaction.domain.Transaction;
import com.bofa.transaction.model.Account;
import com.bofa.transaction.repository.TransactionRepository;
import com.bofa.transaction.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public void createTransaction(Transaction transaction) {
		transactionRepository.save(transaction);
	}

	@Override
	public Transaction findByTransactionId(int transactionId) {

		Transaction transacction = new Transaction();
		Optional<Transaction> optionalTransaction = transactionRepository.findById(transactionId);
		if (optionalTransaction.isPresent()) {
			transacction = optionalTransaction.get();
		}
		return transacction;
	}

	@Override
	public List<Transaction> findAllTransactions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transaction> findTransactionByDate(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transaction> findTransactionsBetweenDates(Date toDate, Date fromDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account deposit(Account account, double amount) {
		double balance = account.getBalance() + amount;
		account.setBalance(balance);
		return account;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public HashMap withdrawal(Account account, double amount) {

		HashMap transactionMap = new HashMap();
		double balance = account.getBalance();
		if (balance >= amount) {
			balance = balance - amount;
			account.setBalance(balance);
			transactionMap.put("fromAccount", account);
			transactionMap.put("status", "success");
		} else {
			transactionMap.put("status", "failed");
		}

		return transactionMap;
	}

	@SuppressWarnings("unchecked")
	@Override
	public HashMap<String, Account> transfer(Account fromAccount, Account toAccount, double amount) {

		@SuppressWarnings("rawtypes")
		HashMap transactionMap = new HashMap<Object, Object>();
		if (fromAccount.getBalance() > amount) {
			fromAccount.setBalance(fromAccount.getBalance() - amount);
			toAccount.setBalance(toAccount.getBalance() + amount);
			transactionMap.put("fromAccount", fromAccount);
			transactionMap.put("toAccount", toAccount);
			transactionMap.put("status", "success");
		} else {
			transactionMap.put("status", "failed");
		}

		return transactionMap;
	}

}
