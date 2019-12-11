
package com.asset.management.dao;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.asset.management.VO.CategoryVo;
import com.asset.management.VO.ListBillVo;
import com.asset.management.VO.ListPageData;
import com.asset.management.VO.PageViewVo;
import com.asset.management.VO.ReimbursementTrackVo;
import com.asset.management.VO.ResponseVO;
import com.asset.management.VO.mapping.CategoryMapper;
import com.asset.management.VO.mapping.ReimbursementMapper;
import com.asset.management.VO.mapping.ReimbursementTrackMapper;
import com.asset.management.dao.entity.CategoryDetails;
import com.asset.management.dao.entity.Employee;
import com.asset.management.dao.entity.ReimbursementDetails;
import com.asset.management.dao.entity.ReimbursementTrack;
import com.asset.management.dao.repository.CategoryRepository;
import com.asset.management.dao.repository.EmployeeRepository;
import com.asset.management.dao.repository.ReimbursementRepository;
import com.asset.management.dao.repository.ReimbursementTrackRepository;

@Component

public class ReimbursementDaoImpl implements ReimbursementDao {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ReimbursementDaoImpl.class);

	ReimbursementListConverter listConverter;

	@Autowired
	ReimbursementMapper reimbursementMapper;

	@Autowired
	ReimbursementTrackMapper reimbursementTrackMapper;

	@Autowired
	CategoryMapper categoryMapper;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	Validator reimbursementValidator;

	@Autowired
	ReimbursementRepository reimbursementRepository;

	@Autowired
	ReimbursementTrackRepository reimbursementTrackRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public ResponseVO applyReimbursement(ReimbursementTrackVo data) {

		logger.info("In Dao Class");
		logger.info("{}", data);

		final ReimbursementTrack reimbursementTrack = reimbursementTrackMapper.voConversion(data);
		logger.info("{}", reimbursementTrack);
		final List<ReimbursementDetails> reimbursementDetails = reimbursementTrack.getReimbursementDetails();
		final ResponseVO returnValue = reimbursementValidator.validate(data);

		final int length = reimbursementDetails.size();
		logger.info(" list size " + length);
		if (returnValue.getStatus().equals("success")) {
			reimbursementTrackRepository.save(reimbursementTrack);
			logger.info("Data inserted Successfully");
		}

		return returnValue;
	}

	@Override
	public ListBillVo getReimbusementDetails(Long reimbursementId) {
		final List<Object[]> billData = reimbursementRepository.findByReimbursementTrack(reimbursementId);
		final ListBillVo listBill = new ListBillVo();
		listBill.setBillDetails(ReimbursementListConverter.reConvertionBill(billData));
		final ReimbursementTrack reimbursementData = reimbursementTrackRepository
				.findByReimbursementId(reimbursementId);
		final Employee empData = employeeRepository.findByEmpNo(reimbursementData.getEmpNo());
		listBill.setTotalCost(reimbursementData.getTotalCost());
		listBill.setEmpNo(empData.getEmpNo());
		listBill.setEmpName(empData.getFirstName() + " " + empData.getLastName());
		listBill.setEmpDesignation(empData.getDesignation());
		logger.info("{}", listBill);
		return listBill;
	}

	@Override
	public List<CategoryVo> getCategoryDetails() {
		final List<CategoryDetails> category = categoryRepository.selectCategory();
		final List<CategoryVo> categoryVo = categoryMapper.entityListConvert(category);
		logger.info("{}", categoryVo);
		return categoryVo;

	}

	@Override
	public List<ReimbursementTrackVo> getReimbusrmentId() {
		final List<ReimbursementTrack> data = reimbursementTrackRepository.getReimbursementId();
		return reimbursementTrackMapper.entityListConvert(data);
	}

	@Override
	public ListPageData getByDate(PageViewVo date) {

		final Pageable pageable = PageRequest.of(date.getPage(), date.getSize(),
				Sort.by("reimbursement_date").descending());
		@SuppressWarnings("unchecked")
		final Page<Object[]> data = (Page<Object[]>) reimbursementTrackRepository.getAllBetweenDates(pageable, date.getDateFrom(),
				date.getDateTo());
		final List<Object[]> dataList = data.getContent();
		final ListPageData pageData = new ListPageData();
		pageData.setReimbursementDetails(ReimbursementListConverter.reConvertion(dataList));
		pageData.setNumber(data.getNumber());
		pageData.setNumberOfElements(data.getNumberOfElements());
		pageData.setSize(data.getSize());
		pageData.setTotalElements(data.getTotalElements()); //
		pageData.setTotalPages(data.getTotalPages());
		logger.info("{}", pageData);
		return pageData;

	}

	@Override
	public ListPageData reimbursementGetEmpDetails(@RequestBody PageViewVo page) {

		final Pageable pageable = PageRequest.of(page.getPage(), page.getSize(),
				Sort.by("reimbursement_date").descending());
		@SuppressWarnings("unchecked")
		final Page<Object[]> data = (Page<Object[]>) reimbursementTrackRepository.findByReimbursementEmpNo(pageable, page.getEmpNo());
		final List<Object[]> dataList = data.getContent();
		final ListPageData pageData = new ListPageData();
		pageData.setReimbursementDetails(ReimbursementListConverter.reConvertion(dataList));
		pageData.setNumber(data.getNumber());
		pageData.setNumberOfElements(data.getNumberOfElements());
		pageData.setSize(data.getSize());
		pageData.setTotalElements(data.getTotalElements()); //
		pageData.setTotalPages(data.getTotalPages());
		logger.info("{}", pageData);
		return pageData;
	}

	@Override
	public ListPageData viewData(PageViewVo page) {

		final Pageable pageable = PageRequest.of(page.getPage(), page.getSize(),
				Sort.by("reimbursement_date").descending());
		@SuppressWarnings("unchecked")
		final Page<Object[]> data = (Page<Object[]>) reimbursementTrackRepository.getReimbursementView(pageable);
		final List<Object[]> dataList = data.getContent();
		final ListPageData pageData = new ListPageData();
		pageData.setReimbursementDetails(ReimbursementListConverter.reConvertion(dataList));
		pageData.setPageable(data.getPageable());
		pageData.setNumber(data.getNumber());
		pageData.setNumberOfElements(data.getNumberOfElements());
		pageData.setSize(data.getSize());
		pageData.setTotalElements(data.getTotalElements());
		pageData.setTotalPages(data.getTotalPages());
		return pageData;
	}

	@Override
	public ListPageData searchEmployeeId(PageViewVo page) {

		final Pageable pageable = PageRequest.of(page.getPage(), page.getSize(),
				Sort.by("reimbursement_date").descending());
		@SuppressWarnings("unchecked")
		final Page<Object[]> data = (Page<Object[]>) reimbursementTrackRepository.findByReimbursementSearchEmpNo(page.getEmpNo(), pageable);
		final List<Object[]> dataList = data.getContent();
		final ListPageData pageData = new ListPageData();
		pageData.setReimbursementDetails(ReimbursementListConverter.reConvertion(dataList));
		pageData.setPageable(data.getPageable());
		pageData.setNumber(data.getNumber());
		pageData.setNumberOfElements(data.getNumberOfElements());
		pageData.setSize(data.getSize());
		pageData.setTotalElements(data.getTotalElements());
		pageData.setTotalPages(data.getTotalPages());
		return pageData;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ListPageData searchEmployeeDate(PageViewVo page) {
		final Pageable pageable = PageRequest.of(page.getPage(), page.getSize(),
				Sort.by("reimbursement_date").descending());
		final Page<Object[]> data = (Page<Object[]>) reimbursementTrackRepository.findByReimbursementSearchEmpNoDate(page.getDateFrom(),
				page.getDateTo(), page.getEmpNo(), pageable);
		final List<Object[]> dataList = data.getContent();
		final ListPageData pageData = new ListPageData();
		pageData.setReimbursementDetails(ReimbursementListConverter.reConvertion(dataList));
		pageData.setPageable(data.getPageable());
		pageData.setNumber(data.getNumber());
		pageData.setNumberOfElements(data.getNumberOfElements());
		pageData.setSize(data.getSize());
		pageData.setTotalElements(data.getTotalElements());
		pageData.setTotalPages(data.getTotalPages());
		return pageData;
	}

}
