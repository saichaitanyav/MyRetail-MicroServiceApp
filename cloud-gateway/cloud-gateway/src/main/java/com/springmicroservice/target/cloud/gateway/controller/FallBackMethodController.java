package com.springmicroservice.target.cloud.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {
	@GetMapping("/productServiceFallBack")
	public String productServiceFallBackMethod() {
		return "Product service is taking long time, please try again later";
	}
	
	@GetMapping("/priceServiceFallBack")
	public String priceServiceFallBackMethod() {
		return "Price service is taking long time, please try again later";
	}

}
