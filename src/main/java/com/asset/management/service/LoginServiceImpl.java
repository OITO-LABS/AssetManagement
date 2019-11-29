package com.asset.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.asset.management.VO.LoginVo;
import com.asset.management.VO.Mail;
import com.asset.management.dao.EmployeeDao;
import com.asset.management.dao.LoginDao;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class LoginServiceImpl implements LoginService {

	@Autowired
    private MailService emailService;
	
	@Autowired
	private LoginDao logDao;
	
	@Autowired
	private EmployeeDao emp;
	//private static final org.slf4j.Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
	
	@Override
	public void sendmail(Mail obj) {
		 Mail mail = new Mail();
	       mail.setTo(obj.getTo());
	        mail.setSubject("OTP Mail");
	        mail.setContent("Hereby,sending you an auto-generated mail from OITO-TRV Internal Project.To confirm your account, "
	        		+ "please click here :https://www.google.com?"+obj.getToken());
	        emailService.sendSimpleMessage(mail);		
	}

	public void resetPassword(LoginVo logVO) {
		String value=logVO.getPassword();
		String token=logVO.getToken();
		logVO.setPassword(generatePasswordToken(value));
		logDao.update(logVO);
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


	@Override
	public Long decryption(String token) {
		Long empId=(long) 11;
		return empId;
	}

	@Override
	public String generatePasswordToken(Long empId) {
		// TODO Auto-generated method stub
		return null;
	}



}
