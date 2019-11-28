package com.asset.management.VO;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReimbursementTrackVo {

	Long reimbursementId;
	String empNo;
	String reimbursementDate;
	double totalCost;
	List<ReimbursementVo> reimbursementDetails;

}
