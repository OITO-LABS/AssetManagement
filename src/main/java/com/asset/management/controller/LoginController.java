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
import com.asset.management.dao.entity.Employee;
import com.asset.management.service.LoginService;

@RestController
@RequestMapping("api/login")
public class LoginController {
	@Autowired
	private LoginService loginService;

	@PostMapping
	public LoginVo login(@RequestBody LoginVo logVo) {
		return loginService.login(logVo);
	}

	@PostMapping("reset")
	public void resetPassword(@RequestBody LoginVo loginVo) {
		try {
			loginService.resetPassword(loginVo);
		} catch (Exception e) {

		}
	}

	@PostMapping("/send-mail")
	public ResponseVO mail(@RequestBody Mail obj) {
		final ResponseVO status = new ResponseVO();
		try {
			String mail=obj.getTo();
			Employee emp=loginService.findEmp(mail);
			obj.setToken(loginService.generatePasswordToken(emp.getEmpId()));
			loginService.sendmail(obj);
			status.setStatus("success");
		} catch (Exception ex) {
			status.setStatus("Failed!");
			status.setMessage(ex.getMessage());
		}
		return status;
	}

	@GetMapping("token/{value}")
	public String getTestId(@PathVariable Long value) {
		try {

			return loginService.generatePasswordToken(value);

		} catch (Exception e) {

		}
		return null;
	}

}
