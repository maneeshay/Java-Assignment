/*
 * This class the implements the method created in interface IUserService
 * @author Manisha Yadav
 */
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
	
	/*
	 * This method implements user signup method.
	 * @param user obejct of User
	 * @return nothing
	 */
	@Override
	public void userSignup(User user) {
		userRepo.save(user);
		
	}
	
	/*
	 * This method implements user login method.
	 * @param email email of user login
	 * @param password password of user login
	 * 
	 * @return nothing
	 */
	@Override
	public User userLogin(String email, String password) {
	
		return userRepo.findByEmailAndPassword(email, password);
	}
	
	/*
	 * This method implements method to check if user exist.
	 * @param emmail user's used email to crate their account
	 * @return boolean value
	 */
	@Override
	public boolean isUserExist(String email) {
		// TODO Auto-generated method stub
		return userRepo.existsByEmail(email);
	}
	
}
