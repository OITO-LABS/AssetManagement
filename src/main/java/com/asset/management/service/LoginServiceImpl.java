package com.asset.management.service;

import org.apache.log4j.spi.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.asset.management.VO.Mail;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class LoginServiceImpl implements LoginService {

	@Autowired
    private MailService emailService;
	
	@Autowired

	@Override
	public void sendmail(Mail obj) {
		 Mail mail = new Mail();
	       mail.setTo(obj.getTo());
	        mail.setSubject("OTP Mail");
	        mail.setContent("Hereby,sending you an auto-generated mail from OITO-TRV Internal Project.To confirm your account, "
	        		+ "please click here :https://www.google.com?"+obj.getToken());
	        emailService.sendSimpleMessage(mail);		
	}


	public void resetPassword() {

	}
	
	
	@Override
	public void validatePassword() {

	}

	@Override
	public String generatePasswordToken(String value) {


		try {

			MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] messageDigest = md.digest((value.toString()).getBytes());
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


}
