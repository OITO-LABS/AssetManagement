package com.asset.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.asset.management.VO.LoginVo;
import com.asset.management.VO.Mail;
import com.asset.management.VO.ResponseVO;
import com.asset.management.dao.LoginDao;
import com.asset.management.dao.entity.Employee;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

@Component
public class LoginServiceImpl implements LoginService {

	@Autowired
	private MailService emailService;
	
	@Autowired
	private LoginDao logDao;

	private static SecretKeySpec secretKey;
	private static byte[] key;

	@Override
	public void sendmail(Mail obj) {
		Mail mail = new Mail();
		mail.setTo(obj.getTo());
		mail.setSubject("OTP Mail");
		mail.setContent("Hereby,sending you an auto-generated mail from OITO-TRV Internal Project.To confirm your account please click here :http://localhost:8080/oito-trv/reset-password"? +obj.getToken());
		emailService.sendSimpleMessage(mail);
	}

	public static void setKey(String myKey) {
		MessageDigest sha = null;
		try {
			key = myKey.getBytes("UTF-8");
			sha = MessageDigest.getInstance("SHA-1");
			key = sha.digest(key);
			key = Arrays.copyOf(key, 16);
			secretKey = new SecretKeySpec(key, "AES");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String generatePasswordToken(Long empId) {

		String result = null;
		try {
			setKey("oitolabs");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			result = Base64.getEncoder().encodeToString(cipher.doFinal(((empId).toString()).getBytes("UTF-8")));
		} catch (Exception ex) {

		}
		return result;
	}


	

	@Override
	public ResponseVO resetPassword(LoginVo loginVo) {
		
		try {
			loginVo.setUsername(loginVo.getUsername());
			loginVo.setToken(loginVo.getToken());
			loginVo.setPassword(encryptPassword(loginVo.getPassword()));
			loginVo.setEmployeeId(decryptToken(loginVo.getToken()));
			return logDao.update(loginVo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseVO response=new ResponseVO();
		response.setStatus("failed");
		return response;
	}

	@Override
	public void validatePassword() {

	}

	@Override
	public String encryptPassword(String password) {

		String result = null;
		try {
			setKey("oitolabs");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			result = Base64.getEncoder().encodeToString(cipher.doFinal(password.getBytes("UTF-8")));
			System.out.println(result);
		} catch (Exception ex) {

		}
		return result;
	}

	@Override
	public String decryptPassword(String password) {

		String result = null;
		try {
			setKey("oitolabs");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			result = new String(cipher.doFinal(Base64.getDecoder().decode(password)));
		} catch (Exception ex) {

		}

		return result;
	}

	@Override
	public Long decryptToken(String token) {

		Long result = null;
		try {
			setKey("oitolabs");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			result = Long.parseLong(new String(cipher.doFinal(Base64.getDecoder().decode(token))));
		} catch (Exception ex) {

		}
		return result;

	}

	@Override
	public LoginVo login(LoginVo logVo) {
		try {
			logVo.setPassword(encryptPassword(logVo.getPassword()));
			return logDao.login(logVo);
		} catch (Exception e) {
			
		}
		return logVo;
	}

	@Override
	public Employee findEmp(String mail) throws Exception {
		return logDao.findEmp(mail);
	}

}
