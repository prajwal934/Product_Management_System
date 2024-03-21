package com.jsp.springboot.product.test.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.springboot.product.test.exception.ProductNotFoundByIdException;

@RestControllerAdvice
public class ApplicationHandler {

	@ExceptionHandler
	public ResponseEntity<ErrorStructure> productNotFoundByIdException(ProductNotFoundByIdException ex){
		
		ErrorStructure errorStructure = new ErrorStructure();
		errorStructure.setStatuscode(HttpStatus.NOT_FOUND.value());
		errorStructure.setErrorMessage(ex.getMessage());
		errorStructure.setRootCause("Product Object With the given Id doesn't exist!!!");
		
		return new ResponseEntity<ErrorStructure>(errorStructure , HttpStatus.NOT_FOUND);
		
	}

}
