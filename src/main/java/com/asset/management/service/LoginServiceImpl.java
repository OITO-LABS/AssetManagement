<<<<<<< HEAD
package com.asset.management.service;

import org.apache.log4j.spi.LoggerFactory;
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
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
		mail.setContent(
				"Hi,\r\n" + 
				" Happy to have you on board and welcome to Oitolabs. Hereby,sending you a URL to setup the credentials of your account.\r\n" + 
				"To confirm your account, please click here : http://localhost:8080/oito-trv/reset-password?t="+obj.getToken());
		emailService.sendSimpleMessage(mail);
	}

	public static void setKey(String myKey) throws Exception {
		MessageDigest sha = null;

		key = myKey.getBytes("UTF-8");
		sha = MessageDigest.getInstance("SHA-1");
		key = sha.digest(key);
		key = Arrays.copyOf(key, 16);
		secretKey = new SecretKeySpec(key, "AES");
		if (key == null) {
			throw new Exception("Error generating key value !!!");
		}
	}

	@Override
	public String generatePasswordToken(Long empId) throws Exception {

		String result = null;
		if (empId == null) {
			throw new Exception("Failed to fetch employee ID");
		}

		setKey("oitolabs");
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		result = Base64.getEncoder().encodeToString(cipher.doFinal(((empId).toString()).getBytes("UTF-8")));
		if (result == null) {
			throw new Exception("Failed to generate Token");
		}
		System.out.println(result);

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
	public String encryptPassword(String password) throws Exception {

		String result = null;
		setKey("oitolabs");
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		result = Base64.getEncoder().encodeToString(cipher.doFinal(password.getBytes("UTF-8")));
		System.out.println(result);
		if (result == null) {
			throw new Exception("Password encryption failed!!!!");
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
	public LoginVo login(LoginVo logVo) throws Exception {
			logVo.setPassword(encryptPassword(logVo.getPassword()));
			return logDao.login(logVo);
	}
	
	@Override
	public Employee findEmp(String mail) throws Exception {
		return logDao.findEmp(mail);
	}
}
=======


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
	//sendmail
	@Override
	public void sendmail(Mail obj) {
		Mail mail = new Mail();
		mail.setTo(obj.getTo());
		mail.setSubject("OTP Mail");
		mail.setContent(
				"Hi,\r\n" + 
				" Happy to have you on board and welcome to Oitolabs. Hereby,sending you a URL to setup the credentials of your account.\r\n" + 
				"To confirm your account, please click here : http://localhost:8080/oito-trv/reset-password?t=" + obj.getToken());
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
	public ResponseVO resetPassword(LoginVo loginVo)throws Exception{
			LoginVo log=new LoginVo();
			log.setUsername(loginVo.getUsername());
			log.setToken(loginVo.getToken());
			log.setPassword(encryptPassword(loginVo.getPassword()));
			log.setEmployeeId(decryptToken(loginVo.getToken()));
			System.out.println(log.getEmployeeId());
			return logDao.update(log);
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
	public LoginVo login(LoginVo logVo) throws Exception {
			logVo.setPassword(encryptPassword(logVo.getPassword()));
			return logDao.login(logVo);
	}

	@Override
	public Employee findEmp(String mail) throws Exception {
		return logDao.findEmp(mail);
	}

}

<<<<<<< HEAD

=======
>>>>>>> f66c1ca5e2fa9450f6c4e5513afbba6007b075b4
>>>>>>> d1f261f9c6be18d9ec7b00e4d68991921b846774
