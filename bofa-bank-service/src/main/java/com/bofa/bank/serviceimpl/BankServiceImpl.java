package com.bofa.bank.serviceimpl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bofa.bank.controller.BankController;
import com.bofa.bank.domain.Bank;
import com.bofa.bank.repository.BankRepository;
import com.bofa.bank.service.BankService;

@Service
@Transactional
public class BankServiceImpl implements BankService {
	 private static final Logger logger = LoggerFactory.getLogger(BankServiceImpl.class);

	@Autowired
	private BankRepository bankRepository;

	@Override
	public void createBank(Bank bank) {
		logger.info("Start create bank - service---->",bank);
		bankRepository.save(bank);
		logger.info("---End create bank - service");
	}

	@Override
	public Bank findBankById(int bankId) {
		Optional<Bank> optionalBank = bankRepository.findById(bankId);

		Bank bank = new Bank();
		if (optionalBank.isPresent()) {
			bank = optionalBank.get();
		}

		return bank;
	}

	@Override
	public void deleteBank(int bankId) {
		bankRepository.deleteById(bankId);		
	}

}
