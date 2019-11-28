package com.asset.management.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asset.management.VO.Mail;
import com.asset.management.service.MailService;

@RestController
@RequestMapping("login")
public class LoginController {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(AssetController.class);
	   @Autowired
	    private MailService emailService;
	   
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

	        emailService.sendSimpleMessage(mail);
	    }
}
