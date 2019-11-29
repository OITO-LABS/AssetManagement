package com.asset.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asset.management.VO.Mail;
import com.asset.management.service.MailService;

@RestController
@RequestMapping("login")
public class LoginController {
	@Autowired
	    private MailService emailService;

	   @PostMapping("/send-mail")
	 public void mail(@RequestBody Mail obj) {
		    Mail mail = new Mail();
	        mail.setTo(obj.getTo());
	        mail.setSubject("OTP Mail");
	        mail.setContent("Hereby,sending you an auto-generated mail from OITO-TRV Internal Project."
	        		+ "\n"+"Your Login credentials:\n\tUsername: "+ obj.getUsername()+ "\n\tPassword : "+obj.getPassword());
	        emailService.sendSimpleMessage(mail);
	    }
}
