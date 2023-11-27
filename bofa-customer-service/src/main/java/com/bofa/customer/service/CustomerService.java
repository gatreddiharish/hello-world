package com.bofa.customer.service;

import java.util.List;
import java.util.Map;

import com.bofa.customer.domain.Account;
import com.bofa.customer.model.AccountModel;
import com.bofa.customer.model.CustomerModel;

public interface CustomerService {

	public void createCustomer(CustomerModel customerModel);

	public CustomerModel findCustomerById(int customerId);
	
	public List<AccountModel> getAccountModels(List<Map<String, Object>> accountList);
	
	public List<AccountModel> getAccountModelsWithFeignClient(List<Account> accountList);

	public void deleteCustomer(int customerId);

}
