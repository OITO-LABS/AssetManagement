package com.asset.management.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.asset.management.VO.LoginVo;
import com.asset.management.VO.ResponseVO;
import com.asset.management.VO.mapping.LoginMapper;
import com.asset.management.dao.entity.Employee;
import com.asset.management.dao.entity.Login;
import com.asset.management.dao.entity.Role;
import com.asset.management.dao.entity.Status;
import com.asset.management.dao.repository.LoginRepository;

@Component
public class LoginDaoImpl implements LoginDao {
	@Autowired
	private LoginRepository loginRepository;
	
	@Autowired
	private LoginMapper loginMap;
	
	@Override
	public ResponseVO create(Employee employee) {
		Login loginEntity=new Login();
		ResponseVO response=new ResponseVO();
		loginEntity.setUsername(employee.getEmail());
		loginEntity.setEmployee(employee);
		loginEntity.setStatus(Status.Inactive);
		loginEntity.setRole(Role.employee);
		if(loginRepository.saveAndFlush(loginEntity).getLoginId()!=null) {
			response.setMessage("Login details added");
			response.setStatus("success");
		}
		return response;
	}

	@Override
	public LoginVo login(LoginVo logVo) throws Exception{
		Login log=loginRepository.findByUsername(logVo.getUsername());
		if(log!=null && log.getPassword().equals(logVo.getPassword())) {
			return loginMap.loginReConvertion(log);
		}
		else {
			throw new Exception("Invalid username or password");
		}
		
	}

	@Override
	public void update(LoginVo loginVo) {
		ResponseVO response=new ResponseVO();
		Login logEntity=loginMap.loginConvertion(loginVo);
		Login log=loginRepository.findByUsername(logEntity.getUsername());
		if(log!= null) {
			response.setMessage("succes");
			response.setStatus("success");
		}
	}

	@Override
	public void delete() {


	}

}
