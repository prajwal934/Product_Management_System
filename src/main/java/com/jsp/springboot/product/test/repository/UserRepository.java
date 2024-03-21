package com.jsp.springboot.product.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.springboot.product.test.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
