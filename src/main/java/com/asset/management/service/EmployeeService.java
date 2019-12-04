
package com.asset.management.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;

import com.asset.management.VO.AssetVO;
import com.asset.management.VO.EmployeeVo;
import com.asset.management.VO.ListPageData;
import com.asset.management.VO.PageViewVo;
import com.asset.management.VO.PaginationVO;
import com.asset.management.dao.entity.Employee;

public interface EmployeeService {

	List<EmployeeVo> selectAll();

	void register(EmployeeVo employee) throws Exception;

	void delete(Long id);

	EmployeeVo view(Long id);

	void update(Long id, EmployeeVo obj) throws Exception;

	Page<Employee> page(PaginationVO pagination);

	List<AssetVO> getAsset(Long id);

	Page<Employee> searchEmployee(PaginationVO pagination);

	void remove(String id);

	List<String> disable(Long login);
	
	

}