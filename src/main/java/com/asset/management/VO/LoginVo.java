package com.asset.management.VO;

import java.util.Date;


import com.asset.management.dao.entity.Employee;
<<<<<<< HEAD
//import com.asset.management.dao.entity.Role;
=======

>>>>>>> 1ac1dcbc133819d06cf2d2efb5364822875809f5
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
//	private Role role;
	private Employee employee;
}
