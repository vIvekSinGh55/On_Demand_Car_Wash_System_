package com.ondemandcarwash.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	@GetMapping("/msg")
	public String message() {
		return "Hello! WELCOME from Payment page";
	}

}
