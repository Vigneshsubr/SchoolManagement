package com.school.schoolmanagement.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {
	
	@GetMapping("/show")
	public String show() {
		return "Hello, I am admin";
	}

}
