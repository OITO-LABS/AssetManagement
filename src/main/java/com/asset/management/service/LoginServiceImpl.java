package com.asset.management.service;

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

	@Override
	public void sendmail(Mail obj) {
		 Mail mail = new Mail();
	       mail.setTo(obj.getTo());
	        mail.setSubject("OTP Mail");
	        mail.setContent("Hi,\n Happy to have you on board and welcome to Oitolabs. Hereby,sending you a URL to setup "
	        		+ "the credentials of your account.\nTo confirm your account, "
	        		+ "please click here :https://www.google.com?"+obj.getToken());
	        emailService.sendSimpleMessage(mail);		
	}

	@Override
	public void resetPassword() {

	}

	@Override
	public String generatePasswordToken(String empId) {

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

	}

}
