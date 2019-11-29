package com.asset.management.dao;

import com.asset.management.VO.LoginVo;
import com.asset.management.VO.ResponseVO;
import com.asset.management.dao.entity.Employee;
public interface LoginDao {
	void login();
	ResponseVO update(LoginVo loginVo);
	void delete();
<<<<<<< HEAD
	
=======
>>>>>>> c022c299afd99f9f3d7af9f44830b75627b52a00
	ResponseVO create(Employee employee);
}

