package com.asset.management.service;

public interface LoginService {
	void resetPassword();
	String generatePasswordToken(Long empId);
	void validatePassword(); 
}
