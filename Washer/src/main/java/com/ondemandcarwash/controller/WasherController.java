package com.ondemandcarwash.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/washer")
public class WasherController {
	@GetMapping("/msg")
	public String message() {
		return "Hello! Welcome form Washer page";
	}

}
