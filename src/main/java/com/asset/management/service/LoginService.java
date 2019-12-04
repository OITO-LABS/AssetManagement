<<<<<<< HEAD
package com.asset.management.service;

import com.asset.management.VO.LoginVo;
import com.asset.management.VO.Mail;
import com.asset.management.VO.ResponseVO;
import com.asset.management.dao.entity.Employee;

public interface LoginService {

	ResponseVO resetPassword(LoginVo loginVo) throws Exception;

	void sendmail(Mail obj);

	String generatePasswordToken(Long empId) throws Exception;

	Long decryptToken(String token);

	String encryptPassword(String password) throws Exception;

	String decryptPassword(String password);

	LoginVo login(LoginVo logVo) throws Exception;

	Employee findEmp(String mail) throws Exception;

}
=======
package com.asset.management.service;

import com.asset.management.VO.LoginVo;
import com.asset.management.VO.Mail;
import com.asset.management.VO.ResponseVO;
import com.asset.management.dao.entity.Employee;

public interface LoginService {

	ResponseVO resetPassword(LoginVo loginVo) throws Exception;

	void sendmail(Mail obj);

	String generatePasswordToken(Long empId) throws Exception;

	Long decryptToken(String token);

	String encryptPassword(String password) throws Exception;

	String decryptPassword(String password);

	LoginVo login(LoginVo logVo) throws Exception;

	Employee findEmp(String mail) throws Exception;

}
>>>>>>> f66c1ca5e2fa9450f6c4e5513afbba6007b075b4
