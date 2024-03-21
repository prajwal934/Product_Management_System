package com.jsp.springboot.product.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.springboot.product.test.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
