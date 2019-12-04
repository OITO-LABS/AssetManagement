<<<<<<< HEAD
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
		ResponseVO response=new ResponseVO();
		try {
			LoginVo logVO=loginService.login(logVo);
			response.setStatus("success");
			logVO.setResponse(response);
			return logVO;
			} catch (Exception e) {
			response.setStatus("failed");
			response.setMessage("Username or password is wrong");
			logVo.setResponse(response);
		}
		return logVo;
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
=======

package com.asset.management.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(AssetController.class);

	// login

	@PostMapping
	public LoginVo login(@RequestBody LoginVo logVo) {
		ResponseVO response=new ResponseVO();
		try {
			LoginVo logVO=loginService.login(logVo);
			response.setStatus("success");
			logVO.setResponse(response);
			return logVO;
		} catch (Exception e) {
			
			e.printStackTrace();
			response.setStatus("failed");
			response.setMessage("Username or password wrong");
			logVo.setResponse(response);
		}
		return logVo;
	}

	@PostMapping("reset")
	public ResponseVO resetPassword(@RequestBody LoginVo loginVo) {
		ResponseVO response=new ResponseVO();
		try {
			response.setStatus("success");
			return loginService.resetPassword(loginVo);
		} catch (Exception e) {
			response.setStatus("failed");
			response.setMessage("invalid mail id");
			e.printStackTrace();

		}
		return response;
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
}

>>>>>>> f66c1ca5e2fa9450f6c4e5513afbba6007b075b4
