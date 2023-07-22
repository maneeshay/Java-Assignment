/*
 * Contact controller handles the mail sending
 * @Version 1.0
 * @author Manisha Yadav
 * 
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
	 * @param contact this is url for contact page
	 */
	@GetMapping("/contact")
	public String getContact() {
		return "contactForm";
	}
	
	/*
	 * This method is used to send the mail to a certain email address.
	 * @param toEmail this is the email where you want to send mail
	 * @param subject this is the subject of the email
	 * @para message this is the message of the email sent
	 * 
	 * @return ContactForm return to contact form again after sending mail
	 */
	@PostMapping("/contact")
	public String postMail(@RequestParam String toEmail,
						   @RequestParam String subject,
						   @RequestParam String message) {
		
		mailUtil.sendEmail(toEmail, subject, message);
		
		return "ContactForm";
	}
}
