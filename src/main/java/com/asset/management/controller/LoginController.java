package com.asset.management.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asset.management.VO.AssetVO;


import com.asset.management.VO.LoginVo;


import com.asset.management.VO.Mail;
import com.asset.management.VO.ResponseVO;
import com.asset.management.service.LoginService;

@RestController
@RequestMapping("api/login")
public class LoginController {
	@Autowired
	private LoginService loginService;

	@PostMapping
	public LoginVo login(LoginVo logVo) {
		return loginService.login(logVo);
	}

	@PostMapping("reset")
	public void resetPassword(@RequestBody LoginVo loginVo) {
		loginService.resetPassword(loginVo);
	}
////////////////
	@PostMapping("/send-mail")
	public ResponseVO mail(@RequestBody Mail obj) {
		final ResponseVO status = new ResponseVO();
		try {
			Long empId = (long) 1000;
			String str = empId.toString();
			obj.setToken(loginService.generatePasswordToken(empId));
			loginService.sendmail(obj);
			status.setStatus("success");
		} catch (Exception ex) {
			status.setStatus("Failed!");
			status.setMessage(ex.getMessage());
		}
		return status;
	}}

