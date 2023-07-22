/*
 * Contact controller handles the mail sending
 * @Version 1.0
 * @Author Manisha Yadav
 * @since 2023-7-22
 * 
 */
package com.techincalround.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techincalround.com.utils.MailUtil;


@Controller
public class ContactController {
	
	@Autowired
	private MailUtil mailUtil;
	
	/*
	 * This method is used to set the url and redirect to required html page
	 * @Param contact this is url for contact page
	 */
	@GetMapping("/contact")
	public String getContact() {
		return "contactForm";
	}
	
	/*
	 * This met
	 */
	@PostMapping("/contact")
	public String postMail(@RequestParam String toEmail,
						   @RequestParam String subject,
						   @RequestParam String message) {
		
		mailUtil.sendEmail(toEmail, subject, message);
		
		return "ContactForm";
	}
}
