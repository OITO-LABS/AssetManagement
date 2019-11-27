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
import com.asset.management.VO.ListDateVo;
import com.asset.management.VO.ListPageData;
import com.asset.management.VO.PageViewEmpVo;
import com.asset.management.VO.ReimbursementTrackVo;
import com.asset.management.VO.ResponseVO;
import com.asset.management.service.ReimbursementService;

// ggggggggpppppppppggggg

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
	public ListPageData viewData(@RequestBody ListDateVo page) {

		return reimbursementService.viewData(page);
	}

	@PostMapping("reimbursement-date")
	public ListPageData getByDate(@RequestBody ListDateVo date) {
		logger.info("{}", date);
		return reimbursementService.getByDate(date);
	}

	@PostMapping("emp-id")
	public ListPageData get(@RequestBody PageViewEmpVo page) {

		return reimbursementService.reimbursementGetEmpDetails(page);

	}
}
