package com.asset.management.VO;

import java.math.BigInteger;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@Setter
public class ReimbursementVo {

	String billDate;
	String reimbursementDescription;
	String categoryName;
	BigInteger billNo;
	double cost;

}