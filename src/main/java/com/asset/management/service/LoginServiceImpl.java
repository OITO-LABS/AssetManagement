package com.asset.management.service;
<<<<<<< HEAD

=======
>>>>>>> 1ac1dcbc133819d06cf2d2efb5364822875809f5
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.asset.management.VO.Mail;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class LoginServiceImpl implements LoginService {
<<<<<<< HEAD
	@Autowired
    private MailService emailService;
	@Override
	public void sendmail(Mail obj) {
		 Mail mail = new Mail();
	        mail.setTo(obj.getTo());
	        mail.setSubject("OTP Mail");
	        mail.setContent("Hereby,sending you an auto-generated mail from OITO-TRV Internal Project.To confirm your account, "
	        		+ "please click here :https://www.google.com?"+obj.getToken());
	        emailService.sendSimpleMessage(mail);		
	}
=======

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
>>>>>>> 1ac1dcbc133819d06cf2d2efb5364822875809f5
	@Override
	public void resetPassword() {

	}
<<<<<<< HEAD
	@Override
=======

>>>>>>> 1ac1dcbc133819d06cf2d2efb5364822875809f5
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

	}
	
<<<<<<< HEAD
=======
///
	@Override
	public void sendmail(Mail obj) {
		 Mail mail = new Mail();
	        mail.setTo(obj.getTo());
	        mail.setSubject("OTP Mail");
	        mail.setContent("Hereby,sending you an auto-generated mail from OITO-TRV Internal Project.To confirm your account, "
	        		+ "please click here :https://www.google.com?"+obj.getToken());	
	}

	@Override
	public void generatePasswordToken() {
		// TODO Auto-generated method stub
		
	}
>>>>>>> 1ac1dcbc133819d06cf2d2efb5364822875809f5

}
