package com.asset.management.service;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.asset.management.VO.ListBillVo;
import com.asset.management.VO.ListPageData;
import com.asset.management.VO.PageViewVo;
import com.asset.management.VO.ReimbursementTrackVo;
import com.asset.management.VO.ResponseVO;
import com.asset.management.dao.ReimbursementDaoImpl;

@Component
public class ReimbursementServiceImpl implements ReimbursementService {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ReimbursementServiceImpl.class);

	@Autowired
	ReimbursementDaoImpl reimbursementDao;

	@Override
	public ResponseVO applyReimbursement(ReimbursementTrackVo data) {
		logger.info("In Service :Get method invoked !!!!!!!!!!");
		return reimbursementDao.applyReimbursement(data);

	}

	@Override
	public ListBillVo getReimbursementDetails(Long reimbursement_id) {

		return reimbursementDao.getReimbusementDetails(reimbursement_id); // reimbursementDao.getReimbusementDetails(reimbursement_id);
	}

	@Override
	public List<ReimbursementTrackVo> getReimbusrmentId() {
		return reimbursementDao.getReimbusrmentId();
	}

	@Override
	public ListPageData reimbursementGetEmpDetails(@RequestBody PageViewVo page) {

		return reimbursementDao.reimbursementGetEmpDetails(page);
	}

	@Override
	public ListPageData viewData(PageViewVo page) {

		return reimbursementDao.viewData(page);
	}

	@Override
	public ListPageData getByDate(PageViewVo date) {

		return reimbursementDao.getByDate(date);

	}

	@Override
	public ListPageData searchEmployee(PageViewVo page) {
		
		return reimbursementDao.searchEmployeeId(page);
	}

	@Override
	public ListPageData searchEmployeeDate(PageViewVo page) {
		return reimbursementDao.searchEmployeeDate(page);
	}
//
}
