package com.bofa.transaction.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bofa.transaction.domain.Transaction;
import com.bofa.transaction.model.Account;
import com.bofa.transaction.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

	@Autowired
	private RestTemplate restTemplate;

	@PostMapping("/create")
	public void createTransaction(@RequestBody Transaction transaction) {
		if (transaction != null) {
			bofaTransactions(transaction);
		}
		transactionService.createTransaction(transaction);
	}

	@GetMapping("/findTransactionById")
	public Transaction findTransactionById(@RequestParam int transactionId) {
		Transaction transaction = transactionService.findByTransactionId(transactionId);
		return transaction;
	}
	
	public Account getAccount(String accountNumber) {		
		Account account = restTemplate.getForObject("http://bofa-account-service/account/findByAccountNumber/"+accountNumber , Account.class);
		return account;
	}
	
	public void updateAccount(Account account) {		
		HttpEntity<Account> request = new HttpEntity<>(account);
		restTemplate.postForObject("http://bofa-account-service/account/create/", request, Account.class);		
	}
	
	public void bofaTransactions(Transaction transaction) {
		String transactionType = transaction.getType();
		if ( transactionType!= null && !transactionType.isEmpty()) {
			if(transactionType.equalsIgnoreCase("deposit")) {				
				updateAccount(transactionService.deposit(getAccount(transaction.getFromAccount()), transaction.getAmount()));
			}else if(transactionType.equalsIgnoreCase("withdrawal")) {
				HashMap<?, ?> transactionMap = transactionService.withdrawal(getAccount(transaction.getFromAccount()), transaction.getAmount());
				if(transactionMap.get("status").equals("success")){
						updateAccount((Account)transactionMap.get("fromAccount"));
				}else {
					System.out.println("Transaction is failed due to insuffient balance");
				}
			}else if(transactionType.equalsIgnoreCase("transfer")) {
				HashMap<?, ?> transactionMap = transactionService.transfer(getAccount(transaction.getFromAccount()),getAccount(transaction.getToAccount()), transaction.getAmount());
				if(transactionMap.get("status").equals("success")){
						updateAccount((Account)transactionMap.get("fromAccount"));
						updateAccount((Account)transactionMap.get("toAccount"));
				}else {
					System.out.println("Transaction is failed due to insuffient balance");
				}
			}else {
				System.out.println("Tansacction Type is incorrect");
			}					
		}
	}

}
