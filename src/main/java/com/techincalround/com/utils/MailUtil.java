/*
 * This class allows us send mail to desired email 
 * @author Manisha Yadav
 */
package com.techincalround.com.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailUtil {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	/*
	 * This method send the email 
	 * @param toEmail receiver's email address
	 * @param subject subject of email body
	 * @param message message for email
	 * 
	 * @return nothing
	 */
	public void sendEmail(String toEmail, String subject, String message) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(toEmail);

        msg.setSubject(subject);
        msg.setText(message);

        javaMailSender.send(msg);

    }

}
