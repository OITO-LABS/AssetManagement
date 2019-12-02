package com.asset.management.dao;

import com.asset.management.VO.LoginVo;
import com.asset.management.VO.ResponseVO;
import com.asset.management.dao.entity.Employee;
public interface LoginDao {
	void login();
	ResponseVO update(LoginVo loginVo);
	void delete();
	ResponseVO create(Employee employee);
}

