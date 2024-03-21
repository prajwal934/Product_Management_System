package com.jsp.springboot.product.test.service;

import org.springframework.http.ResponseEntity;

import com.jsp.springboot.product.test.model.User;
import com.jsp.springboot.product.test.utility.ResponseStructure;

public interface UserService {

	ResponseEntity<ResponseStructure<User>> saveUser(User user);

}
