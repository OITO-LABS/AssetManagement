package com.asset.management.dao;

import java.util.List;

import com.asset.management.VO.AssetAssignVO;
import com.asset.management.VO.ResponseVO;

public interface AssetAssignDao {
	ResponseVO assetAssigned(Long assetId, AssetAssignVO assetAssignVO);

	ResponseVO returnDevice(Long assetId, AssetAssignVO assetAssignVO);

	List<AssetAssignVO> getAll(Long empNo);
}
