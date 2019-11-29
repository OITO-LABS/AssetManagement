
package com.asset.management.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;

import com.asset.management.VO.AssetVO;
import com.asset.management.VO.EmployeeVo;
import com.asset.management.VO.LoginVo;
import com.asset.management.VO.Mail;
import com.asset.management.VO.PaginationVO;
import com.asset.management.VO.mapping.AssetMapperInterface;
import com.asset.management.VO.mapping.EmployeeMapping;
import com.asset.management.dao.entity.Employee;
import com.asset.management.dao.entity.Status;
import com.asset.management.dao.repository.AssetRepository;
import com.asset.management.dao.repository.EmployeeRepository;
import com.asset.management.service.LoginService;

@Component
public class EmployeeDaoImpl implements EmployeeDao {
	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	private AssetRepository AssetRepository;

	@Autowired
	private EmployeeMapping mappingObj;

	@Autowired
	private AssetMapperInterface map;
	
	@Autowired
	private LoginDao loginDao;   
	@Autowired
	private LoginService loginService;
	@Override
	public List<EmployeeVo> selectAll() {
		final List<Employee> employee = employeeRepository.findAll();
		return mappingObj.employeeListConvert(employee);
	}

	@Override
	public void register(EmployeeVo employee) throws Exception {// POST
		final Employee email = employeeRepository.findByEmail(employee.getEmail());
		final Employee contact = employeeRepository.findByContactNo(employee.getContactNo());
		final Employee empNo = employeeRepository.findByEmpNo(employee.getEmpNo());
		final Employee healthCardNo = employeeRepository.findByHealthCardNo(employee.getHealthCardNo());
		final Employee emp = mappingObj.Map(employee);
		if (email == null) {
			if (contact == null) {
				if (empNo == null) {
					if (healthCardNo == null) {
						emp.setStatus(Status.Active);
						employeeRepository.save(emp);
						
					} else {
						throw new Exception("Health Card no already exists!");
					}
				} else {
					throw new Exception("Employee no already exists!");
				}
			} else {
				throw new Exception("Contact no already exists!");
			}
		} else {
			throw new Exception("Email already exists!");
		}
		loginDao.create(emp);

		String id=(emp.getEmpId()).toString();
		Mail obj=new Mail();
		obj.setTo(emp.getEmail());
		obj.setToken(loginService.generatePasswordToken(id));
		loginService.sendmail(obj);

	}

	@Override
	public EmployeeVo view(Long id) {
		Employee emp = null;
		final java.util.Optional<Employee> temp = employeeRepository.findById(id);
		if (temp.isPresent()) {
			emp = temp.get();
		}
		return mappingObj.employeeMap(emp);
	}

	@Override
	public void delete(Long id) {
		employeeRepository.deleteById(id);
	}

	@Override
	@org.springframework.transaction.annotation.Transactional(propagation = Propagation.REQUIRED)
	public void update(Long empId, EmployeeVo obj) {
		final java.util.Optional<Employee> temp = employeeRepository.findById(empId);
		if (temp.isPresent()) {
			final Employee emp = mappingObj.Map(obj);
			employeeRepository.update(empId, emp.getFirstName(), emp.getLastName(), emp.getDesignation(),
					emp.getEmail(), emp.getContactNo(), emp.getDob(), emp.getEmergencyContactName(),
					emp.getEmergencyContact(), emp.getHealthCardNo(), emp.getBloodGroup(), emp.getEmpNo());
		}
	}

	@Override
	@org.springframework.transaction.annotation.Transactional(propagation = Propagation.REQUIRED)
	public void remove(String empNo) {
		final Employee emp = employeeRepository.findByEmpNo(empNo);
		emp.setStatus(Status.Inactive);
		employeeRepository.flush();

	}

	@Override
	public Page<Employee> page(PaginationVO pagination) {
		final Pageable pageable = PageRequest.of(pagination.getPage(), pagination.getLimit());
		final String status = (String.valueOf((Status.Active).ordinal()));
		return employeeRepository.findE(status, pageable);
	}

	@Override
	public Page<Employee> searchEmployee(PaginationVO pagination) {
		final Pageable pageable = PageRequest.of(pagination.getPage(), pagination.getLimit());
		return employeeRepository.searchEmployee(pagination.getSearchkey(), pageable);
	}

	@Override
	public List<AssetVO> getAsset(Long id) {
		final String enableStatus = (String.valueOf((Status.Assigned).name()));
		return map.assetReConvertion(AssetRepository.findByEmployee(id, enableStatus));
	}

	@Override
	public List<String> disable(Long login) {// disable lists for update
		if (login == 0) {// admin
			return new ArrayList<>(List.of("empNo"));
		}
		return new ArrayList<>(List.of("empNo", "designation", "healthCardNo"));
	}

	public Optional<Employee> findEmployee(Long empId) {

		return employeeRepository.findById(empId);
	}

}
