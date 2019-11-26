package com.asset.management.service;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.asset.management.VO.ListBillVo;
import com.asset.management.VO.ListDateVo;
import com.asset.management.VO.ListPageData;
import com.asset.management.VO.PageViewEmpVo;
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
	public ListPageData reimbursementGetEmpDetails(@RequestBody PageViewEmpVo page) {

		return reimbursementDao.reimbursementGetEmpDetails(page);
	}

	@Override
	public ListPageData viewData(ListDateVo page) {

		return reimbursementDao.viewData(page);
	}

	@Override
	public ListPageData getByDate(ListDateVo date) {

		return reimbursementDao.getByDate(date);

	}

}
