package com.bofa.bank.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bofa.bank.domain.Bank;
import com.bofa.bank.service.BankService;

@RestController
@RequestMapping("/bank")
public class BankController {
	
	 private static final Logger logger = LoggerFactory.getLogger(BankController.class);
	
	@Autowired
	private BankService bankService;
	
	@PostMapping("/create")
	public void createBank(@RequestBody Bank bank) {
		logger.info("start createBank - controller---->"+bank.toString());
		bankService.createBank(bank);
		logger.info("-----End createBank");
	}

	@GetMapping("/findById/{bankId}")
	public Bank findBankById(@PathVariable int bankId) {		
		Bank bank = bankService.findBankById(bankId);
		return bank;
	}
	
	@DeleteMapping("/delete/{bankId}")
	public void deleteBank(@PathVariable int bankId) {
		bankService.deleteBank(bankId);
	}

}
