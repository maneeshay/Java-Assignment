package com.techincalround.com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techincalround.com.model.User;
import com.techincalround.com.repository.UserRepository;
import com.techincalround.com.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public void userSignup(User user) {
		userRepo.save(user);
		
	}

	@Override
	public User userLogin(String email, String password) {
	
		return userRepo.findByEmailAndPassword(email, password);
	}

	@Override
	public boolean isUserExist(String email) {
		// TODO Auto-generated method stub
		return userRepo.existsByEmail(email);
	}
	
}
