package com.jsp.springboot.product.test.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.jsp.springboot.product.test.dto.ProductRequest;
import com.jsp.springboot.product.test.model.Product;
import com.jsp.springboot.product.test.utility.ResponseStructure;

public interface ProductService {

	public ResponseEntity<ResponseStructure<Product>> saveProduct(ProductRequest product);

	public ResponseEntity<ResponseStructure<Product>> findByProductId(int productId);

	public ResponseEntity<ResponseStructure<Product>> updateByProductId(int productId , ProductRequest productRequest);

	public ResponseEntity<ResponseStructure<Product>> deleteByProductId(int productId);

	public ResponseEntity<ResponseStructure<List<Product>>> findAllProducts();

}
