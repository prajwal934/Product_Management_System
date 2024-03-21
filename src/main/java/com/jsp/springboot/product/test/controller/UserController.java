package com.jsp.springboot.product.test.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.springboot.product.test.model.User;
import com.jsp.springboot.product.test.service.UserService;
import com.jsp.springboot.product.test.utility.ResponseStructure;

import jakarta.validation.Valid;

@RestController
public class UserController {
	private UserService userService;
	

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}


	@PostMapping(value = "/users")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody  @Valid User user){
		return userService.saveUser(user);
	}
}
