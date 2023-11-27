package com.bofa.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BofaCloudGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(BofaCloudGatewayApplication.class, args);
	}

}
