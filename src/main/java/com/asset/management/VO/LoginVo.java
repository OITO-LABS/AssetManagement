package com.asset.management.VO;

import java.util.Date;


import com.asset.management.dao.entity.Employee;

<<<<<<< HEAD
=======

>>>>>>> 771ea8a596faa7e0fc6e622ea35015014959407a
import com.asset.management.dao.entity.Status;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class LoginVo {
	private String userName;
	private String password;
	private Status status;
	private Date loginTime;
	private Date logoutTime;
	private Employee employee;
}
