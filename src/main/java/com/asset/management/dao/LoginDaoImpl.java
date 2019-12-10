package com.asset.management.dao;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.asset.management.VO.LoginVo;
import com.asset.management.VO.ResponseVO;
import com.asset.management.VO.mapping.EmployeeMapping;
import com.asset.management.VO.mapping.LoginMapper;
import com.asset.management.dao.entity.Employee;
import com.asset.management.dao.entity.Login;
import com.asset.management.dao.entity.Role;
import com.asset.management.dao.entity.Status;
import com.asset.management.dao.repository.EmployeeRepository;
import com.asset.management.dao.repository.LoginRepository;
import com.asset.management.service.LoginService;

@Component
public class LoginDaoImpl implements LoginDao {
	@Autowired
	private LoginRepository loginRepository;
	
	@Autowired
	private LoginMapper loginMap;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	LoginService logService;
	
	@Autowired
	EmployeeMapping empMap;

	@Override
	public ResponseVO create(Employee employee) {
		Login log=new Login();
		ResponseVO response=new ResponseVO();
		log.setUsername(employee.getEmail());
		log.setStatus(Status.Inactive);
		log.setRole(Role.employee);
		log.setEmployeeId(employee.getEmpId());
		try {
			loginRepository.save(log);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(log.getLoginId()!=null) {
			response.setMessage("Login details added");
			response.setStatus("success");
		}
		return response;
	}

	@Override
	public LoginVo login(LoginVo logVo) throws Exception{
		Login log=loginRepository.findByUsername(logVo.getUsername());
		if(log!=null && log.getPassword().equals(logVo.getPassword())) {
			new SimpleDateFormat("dd/MM/yy HH:mm:ss");
			Calendar calobj = Calendar.getInstance();
			log.getPassword();
			log.setLoginTime(calobj.getTime());
			return loginMap.loginReConvertion(log);
		}
		else {
			throw new Exception("Invalid username or password");
		}
		
	}


	@Override
	public void delete() {


	}

	//update
	public ResponseVO update(LoginVo logVo) throws Exception {
		ResponseVO response=new ResponseVO();
		Login logEntity=loginMap.loginConvertion(logVo);
		Login demoEntity=loginRepository.findByEmployeeId(logVo.getEmployeeId());
		if(demoEntity.getUsername().equals(logEntity.getUsername())) {
			demoEntity.setPassword(logEntity.getPassword());
			demoEntity.setStatus(Status.Active);
			loginRepository.save(demoEntity);
			response.setStatus("success");
			
			response.setMessage("Password reset successfully");
		}
		else {
			throw new Exception("Not a valid user");
		}
		return response;
	}

	@Override
	public Employee findEmp(String mail) throws Exception {
		Employee emp = employeeRepository.findByEmail(mail);
		if(emp!=null) {
		return emp;
		}else {
			throw new Exception("Enter your registered e-mail address");
		}
	}



}
