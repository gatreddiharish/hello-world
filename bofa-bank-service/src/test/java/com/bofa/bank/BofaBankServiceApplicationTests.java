package com.bofa.bank;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.bofa.bank.controller.BankController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class BofaBankServiceApplicationTests {

	@Autowired
	BankController bankController;

	@Test
	public void contextLoads() {
		Assertions.assertThat(bankController).isNotNull();
	}
}
