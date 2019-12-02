package com.asset.management.service;

import com.asset.management.VO.LoginVo;
import com.asset.management.VO.Mail;
import com.asset.management.VO.ResponseVO;
import com.asset.management.dao.entity.Employee;

public interface LoginService {

	ResponseVO resetPassword(LoginVo loginVo);


	void validatePassword();

	void sendmail(Mail obj);


	String generatePasswordToken(Long empId);
	
	Long decryptToken(String token);
	
    String encryptPassword(String password);
    
    String decryptPassword(String password);


    LoginVo login(LoginVo logVo);


	Employee findEmp(String mail) throws Exception;

}
