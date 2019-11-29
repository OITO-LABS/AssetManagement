package com.asset.management.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asset.management.VO.Mail;
import com.asset.management.service.LoginService;

@RestController
@RequestMapping("login")
public class LoginController {
	@Autowired
	    private LoginService loginService;
	   
	   @PostMapping
	   public void login() {
	   }
	   
	   @PostMapping("/reset")
	   public void resetPassword() {
		   
	   }
	@PostMapping("/send-mail")
	 public void mail(@RequestBody Mail obj) {
<<<<<<< HEAD
		Long empId=(long) 1000;
		String str=empId.toString();
		obj.setToken(loginService.generatePasswordToken((long) 1000));
=======
		obj.setToken(loginService.generatePasswordToken((String) 1000));
>>>>>>> 6f172681cfb040eac9a0b8d3394bb0502017d250
		   loginService.sendmail(obj);  
	     
	    }///
}
