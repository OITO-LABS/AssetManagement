package com.asset.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.asset.management.VO.Mail;

@Component
public class LoginServiceImpl implements LoginService{
	@Autowired
    private MailService emailService;
	@Override
	public void resetPassword() {
		
	}
	

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
