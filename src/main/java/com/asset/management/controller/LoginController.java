package com.asset.management.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public void resetPassword() {

	}

	@PostMapping("/send-mail")
	public ResponseVO mail(@RequestBody Mail obj) {
		final ResponseVO status = new ResponseVO();
		try {
			Long empId = (long) 1000;
			String str = empId.toString();
			obj.setToken(loginService.generatePasswordToken(str));
			loginService.sendmail(obj);
			status.setStatus("success");
		} catch (Exception ex) {
			status.setStatus("Failed!");
			status.setMessage(ex.getMessage());
		}
		return status;
	}
}
