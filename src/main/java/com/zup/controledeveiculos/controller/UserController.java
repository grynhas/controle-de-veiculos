package com.zup.controledeveiculos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@GetMapping(value = "/todos")
	public String fillAll() {
		return "Hello World";
	}
	
}
