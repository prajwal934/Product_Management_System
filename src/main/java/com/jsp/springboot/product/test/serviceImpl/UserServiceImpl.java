package com.jsp.springboot.product.test.serviceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.springboot.product.test.model.User;
import com.jsp.springboot.product.test.repository.UserRepository;
import com.jsp.springboot.product.test.service.UserService;
import com.jsp.springboot.product.test.utility.ResponseStructure;

@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	private ResponseStructure<User> responseStructure;
	
	
	
	public UserServiceImpl(UserRepository userRepository, ResponseStructure<User> responseStructure) {
		super();
		this.userRepository = userRepository;
		this.responseStructure = responseStructure;
	}



	@Override
	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		User uniqueUser = userRepository.save(user);
		return ResponseEntity.ok(responseStructure.setStatuscode(HttpStatus.OK.value())
				.setMessage("User Data Saved Successfully!!")
				.setData(uniqueUser));
	}
	

}
