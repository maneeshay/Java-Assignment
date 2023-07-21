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
	
	@GetMapping({"/login","/"})
	public String getLoginForm() {
		return "loginForm";
	}
	
	@GetMapping("/signup")
	public String getSignupForm() {
		return "signupForm";
	}
	

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
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		session.invalidate(); //session kill
		return "loginForm";
	}
}
