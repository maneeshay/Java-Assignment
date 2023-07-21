package com.techincalround.com.service;

import com.techincalround.com.model.User;

public interface IUserService {
	void userSignup(User user);
	
	User userLogin(String email, String password);
	
	boolean isUserExist(String email);
	
}
