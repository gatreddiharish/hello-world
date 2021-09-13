package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {
	
	@GetMapping("/hi")
	public String sayHelloSubbarao() {
		return "Welcomne to Subbarao's World";
	}

}
