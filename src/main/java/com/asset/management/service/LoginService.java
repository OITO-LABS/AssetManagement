package com.asset.management.service;

import com.asset.management.VO.Mail;

public interface LoginService {
	void resetPassword();
	void validatePassword();
	void sendmail(Mail obj);
	String generatePasswordToken(Long empId);

}
