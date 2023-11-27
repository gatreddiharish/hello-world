package com.bofa.customer.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bofa.customer.domain.Account;

@FeignClient(value = "bofa-account-service")
public interface AccountServiceClient {
	
	@GetMapping("/account/findByCustomer")
	public List<Account> findAccountsByCustomer(@RequestParam int customerId);

}
