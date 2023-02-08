package com.harsh.springbootdemo.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RESTController {
	
	@GetMapping("/")
	public String sayHello() {
		return "Hello World!! Time is "+LocalDateTime.now();
	}
}
