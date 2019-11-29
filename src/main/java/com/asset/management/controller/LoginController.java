package com.asset.management.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asset.management.VO.LoginVo;
import com.asset.management.VO.Mail;
import com.asset.management.VO.ResponseVO;
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
	   public ResponseVO resetPassword(@RequestBody LoginVo logVo) {
		   return null;
	   }
	@PostMapping("/send-mail")
	 public void mail(@RequestBody Mail obj) {

		Long empId=(long) 1000;
		String str=empId.toString();
		obj.setToken(loginService.generatePasswordToken(str));
		loginService.sendmail(obj);   
	     
	    }
}
