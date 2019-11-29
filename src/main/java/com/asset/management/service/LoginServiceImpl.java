package com.asset.management.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.asset.management.dao.ReimbursementDaoImpl;

@Component
public class LoginServiceImpl implements LoginService {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

	@Override
	public void resetPassword() {

	}

	// <--------- Auto generated password token ------------>
	@Override
	public String generatePasswordToken(Long empId) {

		try {

			MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] messageDigest = md.digest((empId.toString()).getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
            return hashtext;
		}

		catch (NoSuchAlgorithmException e) {  //
			throw new RuntimeException(e);
		}
	}

	@Override
	public void validatePassword() {
		// TODO Auto-generated method stub

	}

}
