package com.asset.management.service;

import com.asset.management.VO.Mail;

public interface LoginService {
	void resetPassword();
<<<<<<< HEAD
	///
	void sendmail(Mail obj);
=======
	String generatePasswordToken(Long empId);
	void validatePassword(); 
>>>>>>> aae4a69e33ab1540d7970b56c4f5fbd43d2d6148
}
