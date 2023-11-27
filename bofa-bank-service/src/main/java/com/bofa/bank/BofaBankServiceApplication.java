package com.bofa.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableDiscoveryClient
//@EnableEurekaClient
public class BofaBankServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BofaBankServiceApplication.class, args);
	}

}
