package com.techincalround.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techincalround.com.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	boolean existsByEmail(String email);
	
	User findByEmailAndPassword(String email,String password);
}
