package com.bofa.customer.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bofa.customer.domain.Account;
import com.bofa.customer.domain.Address;
import com.bofa.customer.domain.Contact;
import com.bofa.customer.domain.Customer;
import com.bofa.customer.model.AccountModel;
import com.bofa.customer.model.AccountTypeModel;
import com.bofa.customer.model.AddressModel;
import com.bofa.customer.model.ContactModel;
import com.bofa.customer.model.CustomerModel;
import com.bofa.customer.repository.CustomerRepository;
import com.bofa.customer.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public void createCustomer(CustomerModel customerModel) {
		customerRepository.save(mapModelToEntity(customerModel));
	}

	@Override
	public CustomerModel findCustomerById(int customerId) {
		Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
		Customer customer = new Customer();
		if (optionalCustomer.isPresent()) {
			customer = optionalCustomer.get();
		}
		CustomerModel customerModel = mapEntityToModel(customer);
		return customerModel;
	}

	@Override
	public void deleteCustomer(int customerId) {
		customerRepository.deleteById(customerId);

	}

	public CustomerModel mapEntityToModel(Customer customer) {

		CustomerModel customerModel = new CustomerModel();
		BeanUtils.copyProperties(customer, customerModel);

		List<AddressModel> addressModelList = new ArrayList<>();
		for (Address address : customer.getAddresses()) {
			AddressModel addressModel = new AddressModel();
			BeanUtils.copyProperties(address, addressModel);
			addressModelList.add(addressModel);
		}
		customerModel.setAddresses(addressModelList);

		List<ContactModel> contactModelList = new ArrayList<>();
		for (Contact contact : customer.getContacts()) {
			ContactModel contactModel = new ContactModel();
			BeanUtils.copyProperties(contact, contactModel);
			contactModelList.add(contactModel);
		}
		customerModel.setContacts(contactModelList);

		return customerModel;

	}
	
	public Customer mapModelToEntity(CustomerModel customerModel) {

		Customer customer = new Customer();
		BeanUtils.copyProperties(customerModel, customer);
		customer.setCustomerId(generateRandomNumber());

		List<Address> addressList = new ArrayList<>();
		for (AddressModel addressModel : customerModel.getAddresses()) {
			Address address = new Address();
			BeanUtils.copyProperties(addressModel, address);
			address.setAddressId(generateRandomNumber());
			address.setCustomer(customer);
			addressList.add(address);
		}
		customer.setAddresses(addressList);

		List<Contact> contactList = new ArrayList<>();
		for (ContactModel contactModel : customerModel.getContacts()) {
			Contact contact = new Contact();
			BeanUtils.copyProperties(contactModel, contact);
			contact.setContactId(generateRandomNumber());
			contact.setCustomer(customer);
			contactList.add(contact);
		}
		customer.setContacts(contactList);

		return customer;

	}

	public List<AccountModel> getAccountModels(List<Map<String, Object>> accountList) {
		List<AccountModel> accountModelList = new ArrayList<>();
		for (Map<String, Object> accountMap : accountList) {
			System.out.println("accountMap----" + accountMap.toString());
			final ObjectMapper mapper = new ObjectMapper();
			Account account = mapper.convertValue(accountMap, Account.class);
			// BeanUtils.populate(account, accountMap);
			AccountModel accountModel = new AccountModel();
			BeanUtils.copyProperties(account, accountModel);

			AccountTypeModel accountTypeModel = new AccountTypeModel();
			BeanUtils.copyProperties(account.getAccountType(), accountTypeModel);
			accountModel.setAccountType(accountTypeModel);
			accountModelList.add(accountModel);
		}
		return accountModelList;
	}
	
	public List<AccountModel> getAccountModelsWithFeignClient(List<Account> accountList) {
		List<AccountModel> accountModelList = new ArrayList<>();
		for (Account account : accountList) {
			AccountModel accountModel = new AccountModel();
			BeanUtils.copyProperties(account, accountModel);
			
			AccountTypeModel accountTypeModel = new AccountTypeModel();
			BeanUtils.copyProperties(account.getAccountType(), accountTypeModel);
			accountModel.setAccountType(accountTypeModel);
			accountModelList.add(accountModel);			
		}
		return accountModelList;
		
	}
	
	public int generateRandomNumber() {
		Random objGenerator = new Random();
		int randomNumber = objGenerator.nextInt(1000)%-101;
		System.out.println("randomNumber----->"+randomNumber);
		return randomNumber;
	}
}
