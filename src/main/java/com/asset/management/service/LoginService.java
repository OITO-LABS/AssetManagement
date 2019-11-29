package com.asset.management.service;

import com.asset.management.VO.LoginVo;
import com.asset.management.VO.Mail;

public interface LoginService {
	void resetPassword(LoginVo logVO);
	void validatePassword();
	void sendmail(Mail obj);
	String generatePasswordToken(String value);
	Long decryption(String token);
}
