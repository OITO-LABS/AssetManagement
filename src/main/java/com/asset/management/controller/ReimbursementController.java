package com.asset.management.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asset.management.VO.ListBillVo;
import com.asset.management.VO.ListPageData;
import com.asset.management.VO.PageViewVo;
import com.asset.management.VO.ReimbursementTrackVo;
import com.asset.management.VO.ResponseVO;
import com.asset.management.service.ReimbursementService;

@RestController
@RequestMapping("api/reimbursement")
public class ReimbursementController {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ReimbursementController.class);

	@Autowired
	private ReimbursementService reimbursementService;

	@PostMapping("apply")
	public ResponseVO applyReimbursement(@RequestBody ReimbursementTrackVo data) {

		logger.info("{}", data);
		logger.info("{}", data.getReimbursementDetails());
		return reimbursementService.applyReimbursement(data);

	}

//	@GetMapping("category")
//	public List<CategoryVo> selectAll() {
//		return reimbursementService.getCategoryDetails();
//	}

	@GetMapping("emp-id/{reimbursementId}")
	public ListBillVo get(@PathVariable Long reimbursementId) {

		return reimbursementService.getReimbursementDetails(reimbursementId);

	}

	@PostMapping("reimbursement-list")
	public ListPageData viewData(@RequestBody PageViewVo page) {
		try {
			final ListPageData responseData = reimbursementService.viewData(page);
		} catch (final NullPointerException ex) {
			logger.info(ex.getMessage());
		}
		return reimbursementService.viewData(page);
	}

	@PostMapping("reimbursement-date")
	public ListPageData getByDate(@RequestBody PageViewVo date) {
		logger.info("{}", date);
		return reimbursementService.getByDate(date);
	}

	@PostMapping("emp-id")
	public ListPageData get(@RequestBody PageViewVo page) {

		return reimbursementService.reimbursementGetEmpDetails(page);

	}
	
	@PostMapping("search-emp-id")
	public ListPageData searchEmployeeId(@RequestBody PageViewVo page) {

		return reimbursementService.searchEmployee(page);

	}
	
	@PostMapping("search-emp-id-date")
	public ListPageData searchEmployeeDate(@RequestBody PageViewVo page) {

		return reimbursementService.searchEmployeeDate(page);
	}
	
	
}
