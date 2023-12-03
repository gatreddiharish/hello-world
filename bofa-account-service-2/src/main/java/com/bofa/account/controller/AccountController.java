package com.bofa.account.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bofa.account.domain.Account;
import com.bofa.account.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@PostMapping("/create")
	public void createAccount(@Validated @RequestBody Account account) {
		accountService.createAccount(account);
	}

	@GetMapping("/findByCustomer")
	public List<Account> findAccountsByCustomer(@RequestParam int customerId) {
		List<Account> accounts = accountService.findAccountsByCustomer(customerId);
		return accounts;
	}

	@GetMapping("/findByAccountNumber/{accountNumber}")
	public Account findByAccountNumber(@PathVariable String accountNumber) {
		Account account = accountService.findByAccountNumber(accountNumber);
		return account;
	}

}
