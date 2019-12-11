
package com.asset.management.dao;

import java.util.Calendar;
import java.util.List;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.asset.management.VO.AssetDetailsVO;
import com.asset.management.VO.AssetVO;
import com.asset.management.VO.PageData;
import com.asset.management.VO.PaginationVO;
import com.asset.management.VO.ProductCategoryVO;
import com.asset.management.VO.ResponseVO;
import com.asset.management.VO.mapping.AssetMapperInterface;
import com.asset.management.VO.mapping.ProductCategoryMapperInterface;
import com.asset.management.dao.entity.AssetAssignEntity;
import com.asset.management.dao.entity.AssetEntity;
import com.asset.management.dao.entity.ProductCategoryEntity;
import com.asset.management.dao.entity.Status;
import com.asset.management.dao.repository.AssetAssignRepository;
import com.asset.management.dao.repository.AssetRepository;
import com.asset.management.dao.repository.ProductCategoryRepository;

@Component
public class AssetDaoImpl implements AssetDao {
	@Autowired
	private AssetMapperInterface map;
	@Autowired
	private ProductCategoryRepository productRepository;
	@Autowired
	private AssetRepository assetRepository;
	@Autowired
	ProductCategoryMapperInterface productMap;
	@Autowired
	AssetAssignRepository assetAssignRepository;
	@Autowired
	private Validation validator;

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(AssetDao.class);

	// Add / Register a new device.

	@Override
	public ResponseVO create(AssetVO assetVO) {
		final AssetEntity assetEntity = map.assetConvertion(assetVO);
		final ResponseVO response = validator.addValidation(assetEntity);

		if (response.getStatus().equals("Success")) {

			final Calendar cal = Calendar.getInstance();
			assetEntity.setEnableStatus(Status.Unassigned);
			assetEntity.setAddDate(cal.getTime());
			assetEntity.setUpdatedDate(cal.getTime());

			if (assetRepository.saveAndFlush(assetEntity).getAssetId() != null) {

				response.setMessage("Asset added successfully");
				response.setStatus("success");
				return response;

			}

		}

		return response;

	}

	@Override
	public List<ProductCategoryVO> productCategoryDetails() {
		final List<ProductCategoryEntity> productEntity = productRepository.findAll();
		return productMap.assetReConvertion(productEntity);
	}

	// Provide asset details using pagination.

	@Override
	public PageData getAssetDetails(PaginationVO paginationVO) {

		final Pageable pageable = PageRequest.of(paginationVO.getPage(), paginationVO.getLimit());
		final String productName = paginationVO.getSearchkey();
		final Page<Object[]> asset = assetAssignRepository.findSelectedField(productName, pageable);

		final List<Object[]> assetList = asset.getContent();
		final PageData data = new PageData();

		data.setResultSet(AssetListConverter.reConvertion(assetList));
		data.setPageable(asset.getPageable());
		data.setNumber(asset.getNumber());
		data.setNumberOfElements(asset.getNumberOfElements());
		data.setSize(asset.getSize());
		data.setTotalElements(asset.getTotalElements());
		data.setTotalPages(asset.getTotalPages());
		logger.info("{ListConverter.pageConvertion(asset.getContent())}");
		return data;

	}

	// Delete a an asset by updating the status fields of asset_details and
	// device_assignment table.

	@Override
	public ResponseVO deleteAsset(Long id) {
		final ResponseVO response = new ResponseVO();
		final AssetEntity asset = assetRepository.findByAssetId(id);
		final AssetAssignEntity assetAssignEntity = assetAssignRepository.findByAssetAssign(asset.getAssetId());

		if (asset != null) {
			final Calendar cal = Calendar.getInstance();
			asset.setEnableStatus(Status.Disabled);
			asset.setUpdatedDate(cal.getTime());

			if (assetAssignEntity != null) {
				assetAssignEntity.setAssignStatus(Status.Disabled);
				assetAssignEntity.setUpdatedDate(cal.getTime());
				assetAssignRepository.saveAndFlush(assetAssignEntity);
			}

			if (assetRepository.saveAndFlush(asset).getAssetId() != null) {
				response.setStatus("deleted successfully");
				response.setMessage("Deletion success");
				return response;
			}
		}
		response.setMessage("Deletion success");
		response.setStatus("failed");
		return response;
	}

	// Retrieve the details of a particular asset by id.

	@Override
	public List<AssetDetailsVO> getById(Long id) {
		final List<Object[]> resultSet = assetRepository.getAssetDetails(id);
		return AssetListConverter.assetConverter(resultSet);
	}

	@Override
	public PageData getAllAsset(PaginationVO paginationVO) {
		final Pageable pageable = PageRequest.of(paginationVO.getPage(), paginationVO.getLimit());
		@SuppressWarnings("unchecked")
		final Page<Object[]> asset = (Page<Object[]>) assetAssignRepository.findAssetDetails(pageable);
		final List<Object[]> assetList = asset.getContent();
		final PageData data = new PageData();
		data.setResultSet(AssetListConverter.reConvertion(assetList));
		data.setPageable(asset.getPageable());
		data.setNumber(asset.getNumber());
		data.setNumberOfElements(asset.getNumberOfElements());
		data.setSize(asset.getSize());
		data.setTotalElements(asset.getTotalElements());
		data.setTotalPages(asset.getTotalPages());
		logger.info("{ListConverter.pageConvertion(asset.getContent())}");
		return data;
	}

	@Override
	public List<AssetDetailsVO> getAssetHistory(Long assetId) {
		final List<Object[]> assetHistory = assetAssignRepository.findAssetHistory(assetId);
		return AssetListConverter.historyConverter(assetHistory);
	}

	@Override
	public ResponseVO updateAssetDetails(Long assetId, AssetVO assetVO) {

		final AssetEntity assetEntity = map.assetConvertion(assetVO);
		final ResponseVO response = validator.updateValidation(assetId, assetEntity);

		if (response.getStatus().equals("success")) {
			final AssetEntity asset = assetRepository.getOne(assetId);
			asset.setModel(assetVO.getModel());
			asset.setSimNo(assetVO.getSimNo());
			asset.setMsisdnNo(assetVO.getMsisdnNo());
			asset.setProductCategory(assetVO.getProductCategory());
			asset.setUpdatedId(assetVO.getUpdatedId());

			if (assetRepository.saveAndFlush(asset).getAssetId() != null) {
				response.setMessage("Updated successfully");
				response.setStatus("success");
				return response;
			}
		}
		return response;
	}

	@Override
	public AssetVO getAssetById(Long assetId) {
		final AssetEntity asset = assetRepository.findByAssetId(assetId);
		return map.assetReConvertion(asset);
	}

}

