package com.asset.management.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.asset.management.VO.CategoryVo;
import com.asset.management.VO.ListBillVo;
import com.asset.management.VO.ListPageData;
import com.asset.management.VO.PageViewVo;
import com.asset.management.VO.ReimbursementTrackVo;
import com.asset.management.VO.ResponseVO;

public interface ReimbursementService {

	ResponseVO applyReimbursement(ReimbursementTrackVo data);

	ListBillVo getReimbursementDetails(Long reimbursement_id);

	List<ReimbursementTrackVo> getReimbusrmentId();

	List<CategoryVo> getCategoryDetails();

	ListPageData getByDate(PageViewVo date);

	ListPageData reimbursementGetEmpDetails(@RequestBody PageViewVo page);

	ListPageData viewData(PageViewVo page);

	ListPageData searchEmployee(@RequestBody PageViewVo page);

	ListPageData searchEmployeeDate(@RequestBody PageViewVo page);

	ListPageData getBillByDate(@RequestBody PageViewVo page);
}
