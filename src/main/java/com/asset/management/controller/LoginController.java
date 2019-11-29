package com.asset.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
=======
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
>>>>>>> 8c0dffa4684cb42b01bf012ff424881869d23a75
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asset.management.VO.Mail;
import com.asset.management.service.MailService;

@RestController
@RequestMapping("login")
public class LoginController {
	@Autowired
	    private MailService emailService;
<<<<<<< HEAD

	   @PostMapping("/send-mail")
	 public void mail(@RequestBody Mail obj) {
		    Mail mail = new Mail();
	        mail.setTo(obj.getTo());
	        mail.setSubject("OTP Mail");
	        mail.setContent("Hereby,sending you an auto-generated mail from OITO-TRV Internal Project."
	        		+ "\n"+"Your Login credentials:\n\tUsername: "+ obj.getUsername()+ "\n\tPassword : "+obj.getPassword());
=======
	   
	   @PostMapping
	   public void login() {
		   logger.info("Hi");
	   }
	   @GetMapping("/send-mail")
	 public void mail() throws Exception {
		 logger.info("Spring Mail - Sending Simple Email ");

	        Mail mail = new Mail();
	        mail.setFrom("no-reply@memorynotfound.com");
	        mail.setTo("info@memorynotfound.com");
	        mail.setSubject("Sending Simple Email with JavaMailSender Example");
	        mail.setContent("This tutorial demonstrates how to send a simple email using Spring Framework.");

>>>>>>> 8c0dffa4684cb42b01bf012ff424881869d23a75
	        emailService.sendSimpleMessage(mail);
	    }
}
