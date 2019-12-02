package com.asset.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public LoginVo login(LoginVo logVo) {
		return loginService.login(logVo);
	}

	@PostMapping("reset")
	public void resetPassword(@RequestBody LoginVo loginVo) {
		loginService.resetPassword(loginVo);
	}

//	@PostMapping("/send-mail")
//	public ResponseVO mail(@RequestBody Mail obj) {
//		final ResponseVO status = new ResponseVO();
//		try {
//			Long empId = (long) 1000;
//			obj.setToken(loginService.generatePasswordToken(empId));
//			loginService.sendmail(obj);
//			status.setStatus("success");
//		} catch (Exception ex) {
//			status.setStatus("Failed!");
//			status.setMessage(ex.getMessage());
//		}
//		return status;
//	}
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
}

