/*
 * This class deals with user login and registration
 */
package com.techincalround.com.controller;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.techincalround.com.model.User;
import com.techincalround.com.service.IUserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	//private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private IUserService service;
	
	/*
	 * This method opens the login form
	 * @return loginForm login form
	 */
	@GetMapping({"/login","/"})
	public String getLoginForm() {
		return "loginForm";
	}
	
	/*
	 * Open signup form
	 * @return signupForm signup form 
	 */
	@GetMapping("/signup")
	public String getSignupForm() {
		return "signupForm";
	}
	
	/*
	 * This method register the user
	 * @param user object of model user
	 * @param model model
	 * 
	 * @return loginForm login form for user
	 * @return signupForm signup form for user
	 */
	@PostMapping("/signupp")
	public String saveUser(@ModelAttribute User user, Model model) {
		
		//check if user exist
		if(!service.isUserExist(user.getEmail())) {
			//password encryption
			user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
			service.userSignup(user);
			
			return "loginForm";
		}
		model.addAttribute("message","Username already exist");
		return "signupForm";
	}
	
	/*
	 * This method deals with user login
	 * @param user object of User model
	 * @param session user interval inside the app
	 * 
	 * @return home home page
	 */
	@PostMapping("/login")
	public String userLogin(@ModelAttribute User user, Model model, HttpSession session) {
		
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		
		User usr = service.userLogin(user.getEmail(), user.getPassword());
		
		if(usr!=null) {
			
			session.setAttribute("user", usr);
			//autokill after certain time in sec
			session.setMaxInactiveInterval(200);
			
			return "home";
			
		}
		else {
			model.addAttribute("message", "User doesnot exist");
			return "loginForm";
		}
		
	}
	
	/*
	 * This method deals with logout of user from app
	 * @param session user interval inside the app
	 * 
	 * @return loginForm Login Form of a user
	 */
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		session.invalidate(); //session kill
		return "loginForm";
	}
	
}
