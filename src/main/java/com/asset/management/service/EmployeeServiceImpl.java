package com.asset.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.asset.management.VO.AssetVO;
import com.asset.management.VO.EmployeeVo;
import com.asset.management.VO.PaginationVO;
import com.asset.management.dao.EmployeeDao;
import com.asset.management.dao.entity.Employee;

@Component
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao daoobj;

	@Override
	public List<EmployeeVo> selectAll() {
		return daoobj.selectAll();

	}

	@Override
	public void register(EmployeeVo employee) throws Exception {
		daoobj.register(employee);
	}

	@Override
	public void delete(Long id) {
		daoobj.delete(id);

	}

	@Override
	public EmployeeVo view(Long id) {
		return daoobj.view(id);
	}

	@Override
	public void update(Long id, EmployeeVo obj) throws Exception {
		daoobj.update(id, obj);
	}

	@Override
	public void remove(String id) {
		daoobj.remove(id);
	}

	@Override
	public Page<Employee> page(PaginationVO pagination) {
		return daoobj.page(pagination);
	}

	@Override
	public List<AssetVO> getAsset(Long id) {
		return daoobj.getAsset(id);
	}

	@Override
	public Page<Employee> searchEmployee(PaginationVO pagination) {
		return daoobj.searchEmployee(pagination);
	}

	@Override
	public List<String> disable(Long login) {
		return daoobj.disable(login);
	}
}