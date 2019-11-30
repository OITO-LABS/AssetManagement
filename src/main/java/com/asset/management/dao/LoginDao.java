package com.asset.management.dao;

import com.asset.management.VO.LoginVo;
import com.asset.management.VO.ResponseVO;
import com.asset.management.dao.entity.Employee;
public interface LoginDao {
	void login();
	void delete();
	ResponseVO create(Employee employee);
	void update(LoginVo loginVo);
}

