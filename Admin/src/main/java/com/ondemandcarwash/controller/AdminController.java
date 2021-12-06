package com.ondemandcarwash.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
	@GetMapping("/msg")
	public String message() {
		return "Hello! WELCOME from Admin Side";
	}

}
