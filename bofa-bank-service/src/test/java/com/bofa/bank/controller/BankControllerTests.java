/*
 * package com.bofa.bank.controller;
 * 
 * import java.util.List;
 * 
 * import org.assertj.core.util.Arrays; import org.mockito.Mockito; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.mock.mockito.MockBean; import
 * org.springframework.test.web.servlet.MockMvc;
 * 
 * import com.bofa.bank.domain.Bank; import com.bofa.bank.service.BankService;
 * 
 * public class BankControllerTests {
 * 
 * 
 * @MockBean BankService bankService;
 * 
 * @Autowired MockMvc mockMvc;
 * 
 * public void create()throws Exception{
 * 
 * Bank bank = new Bank(339, "harish"); List<Object> banks =
 * Arrays.asList(bank);
 * 
 * Mockito.when(bankService.createBank(bank));
 * 
 * mockMvc.perform(post("/bank"))
 * 
 * 
 * } }
 */