package com.asset.management.VO;

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
	double billNo;
	double cost;

}