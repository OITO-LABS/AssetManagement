package com.asset.management.dao;

import com.asset.management.VO.LoginVo;
import com.asset.management.VO.ResponseVO;
public interface LoginDao {
	void login();
	void update();
	void delete();
	ResponseVO create(LoginVo loginVo);
}

