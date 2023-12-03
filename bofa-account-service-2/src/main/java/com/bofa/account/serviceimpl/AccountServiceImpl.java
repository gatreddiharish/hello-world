package com.bofa.account.serviceimpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bofa.account.domain.Account;
import com.bofa.account.repository.AccountRepository;
import com.bofa.account.service.AccountService;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public void createAccount(Account account) {
		accountRepository.save(account);
	}

	@Override
	public List<Account> findAccountsByCustomer(int customerId) {
		List<Account> accounts = accountRepository.findByCustomerId(customerId);
		return accounts;
	}

	@Override
	public Account findByAccountNumber(String accountNumber) {
		Account account = new Account();
		Optional<Account> optionalAccount = accountRepository.findById(accountNumber);
		if (optionalAccount.isPresent()) {
			account = optionalAccount.get();
		}
		return account;

	}

}
