package com.bofa.customer.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bofa.customer.client.AccountServiceClient;
import com.bofa.customer.model.AccountModel;
import com.bofa.customer.model.CustomerModel;
import com.bofa.customer.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private AccountServiceClient accountServiceClient;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/create")
	public void createCustomer(@RequestBody CustomerModel customerModel) {
		customerService.createCustomer(customerModel);
	}

	@GetMapping("/findById/{customerId}")
	public CustomerModel findBycustomerId(@PathVariable int customerId) {
		CustomerModel customerModel = customerService.findCustomerById(customerId);	
		//List<AccountModel> accountModelList = customerService.getAccountModels(findAccountsByCustomerId(customerId));
		List<AccountModel> accountModelList = customerService.getAccountModelsWithFeignClient(accountServiceClient.findAccountsByCustomer(customerId));	
		customerModel.setAccountList(accountModelList);
		return customerModel;
	}

	@DeleteMapping("/delete/{customerId}")
	public void deleteCustomer(@PathVariable int customerId) {
		customerService.deleteCustomer(customerId);
	}
	
	//@GetMapping("/findAccountByCustomerId/{customerId}")
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> findAccountsByCustomerId(int customerId){		
		List<Map<String, Object>> accountList= restTemplate.getForObject("http://bofa-account-service/account/findByCustomer?customerId="+customerId, List.class);		
		System.out.println("accountList-----from findAccountsByCustomerId--"+accountList.toString());
		return accountList;
	}
}
