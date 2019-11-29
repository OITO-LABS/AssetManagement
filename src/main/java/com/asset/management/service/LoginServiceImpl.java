package com.asset.management.service;
<<<<<<< HEAD

=======
>>>>>>> bc7f4fe861594ea970fd5a029bf16b4c09cc11df
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
	
<<<<<<< HEAD
=======
	//private static final org.slf4j.Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
	
>>>>>>> bc7f4fe861594ea970fd5a029bf16b4c09cc11df
	@Override
	public void sendmail(Mail obj) {
		 Mail mail = new Mail();
	       mail.setTo(obj.getTo());
	        mail.setSubject("OTP Mail");
	        mail.setContent("Hereby,sending you an auto-generated mail from OITO-TRV Internal Project.To confirm your account, "
	        		+ "please click here :https://www.google.com?"+obj.getToken());
	        emailService.sendSimpleMessage(mail);		
	}

	@Override
	public void resetPassword() {

	}
<<<<<<< HEAD
	
	@Override
	public void validatePassword() {

	}

	@Override
	public String generatePasswordToken(String empId) {
=======

	@Override
	public String generatePasswordToken(String value) {
>>>>>>> bc7f4fe861594ea970fd5a029bf16b4c09cc11df

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
