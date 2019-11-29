package com.asset.management.service;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.asset.management.VO.Mail;

@Component
public class LoginServiceImpl implements LoginService{
	@Autowired
    private MailService emailService;
=======
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.asset.management.dao.ReimbursementDaoImpl;

@Component
public class LoginServiceImpl implements LoginService {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

>>>>>>> aae4a69e33ab1540d7970b56c4f5fbd43d2d6148
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
	
///
	@Override
	public void sendmail(Mail obj) {
		 Mail mail = new Mail();
	        mail.setTo(obj.getTo());
	        mail.setSubject("OTP Mail");
	        mail.setContent("Hereby,sending you an auto-generated mail from OITO-TRV Internal Project.To confirm your account, "
	        		+ "please click here :https://www.google.com?"+obj.getToken());
	        emailService.sendSimpleMessage(mail);		
	}

}
