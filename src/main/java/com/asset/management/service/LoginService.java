package com.asset.management.service;

import com.asset.management.VO.Mail;

public interface LoginService {
	void resetPassword();
<<<<<<< HEAD
=======
	void generatePasswordToken();
	void validatePassword();
	///
>>>>>>> 1ac1dcbc133819d06cf2d2efb5364822875809f5
	void sendmail(Mail obj);
	String generatePasswordToken(Long empId);
	void validatePassword(); 
}
