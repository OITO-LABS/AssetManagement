package com.asset.management.service;

import java.util.List;

import com.asset.management.VO.AssetDetailsVO;
import com.asset.management.VO.AssetVO;
import com.asset.management.VO.PageData;
import com.asset.management.VO.PaginationVO;
import com.asset.management.VO.ProductCategoryVO;
import com.asset.management.VO.ResponseVO;

public interface AssetService {
	ResponseVO create(AssetVO assetVO);

	List<ProductCategoryVO> productCategoryDetails();

	ResponseVO deleteAsset(Long id);

	List<AssetDetailsVO> getById(Long id);

	PageData getAssetDetails(PaginationVO paginationVO);

	PageData getAllAsset(PaginationVO paginationVO);

	List<AssetDetailsVO> getAssetHistory(Long assetId);

	ResponseVO updateAssetDetails(Long assetId, AssetVO assetVO);

	AssetVO getAssetById(Long assetId);
}
