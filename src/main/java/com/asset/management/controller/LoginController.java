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
import com.asset.management.service.LoginService;

@RestController
@RequestMapping("api/login")
public class LoginController {
	@Autowired
	private LoginService loginService;

	@PostMapping
	public void login() {
	}

	@PostMapping("reset")
	public void resetPassword(@RequestBody LoginVo loginVo) {
		loginService.resetPassword(loginVo);
	}

	@PostMapping("/send-mail")
	public void mail(@RequestBody Mail obj) {

		Long empId = (long) 1000;
		String str = empId.toString();
		obj.setToken(loginService.generatePasswordToken((long) 1000));
		loginService.sendmail(obj);

	}///

}
