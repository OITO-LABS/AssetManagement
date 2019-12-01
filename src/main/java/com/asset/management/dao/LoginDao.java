package com.asset.management.dao;

import com.asset.management.VO.LoginVo;
import com.asset.management.VO.ResponseVO;
import com.asset.management.dao.entity.Employee;
public interface LoginDao {
	LoginVo login(LoginVo logVo) throws Exception;
	void delete();
	ResponseVO create(Employee employee);
	void update(LoginVo loginVo);
}

