package com.asset.management.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.asset.management.VO.ListBillVo;
import com.asset.management.VO.ListDateVo;
import com.asset.management.VO.ListPageData;
import com.asset.management.VO.PageViewEmpVo;
import com.asset.management.VO.ReimbursementTrackVo;
import com.asset.management.VO.ResponseVO;

public interface ReimbursementService {

	ResponseVO applyReimbursement(ReimbursementTrackVo data);

	ListBillVo getReimbursementDetails(Long reimbursement_id);

	List<ReimbursementTrackVo> getReimbusrmentId();

	ListPageData getByDate(ListDateVo date);

	ListPageData reimbursementGetEmpDetails(@RequestBody PageViewEmpVo page);

	ListPageData viewData(ListDateVo page);
}
