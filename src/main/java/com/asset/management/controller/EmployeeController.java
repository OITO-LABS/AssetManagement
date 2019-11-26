package com.asset.management.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asset.management.VO.AssetVO;
import com.asset.management.VO.EmployeeVo;
import com.asset.management.VO.PaginationVO;
import com.asset.management.VO.ResponseVO;
import com.asset.management.dao.entity.Employee;
import com.asset.management.service.EmployeeService;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("listall") // List basic details of all
	public List<EmployeeVo> selectAll() {
		return employeeService.selectAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<EmployeeVo> employeeget(@PathVariable Long id) {
		final EmployeeVo obj = employeeService.view(id);
		return ResponseEntity.ok(obj);
	}

	@GetMapping("asset/{id}")
	List<AssetVO> getAsset(@PathVariable Long id) {
		return employeeService.getAsset(id);
	}

	@PostMapping("/search")
	public Page<Employee> search(@Valid @RequestBody PaginationVO pagination) {
		return employeeService.searchEmployee(pagination);
	}

	@PostMapping("/list")
	public Page<Employee> page(@Valid @RequestBody PaginationVO pagination) {
		return employeeService.page(pagination);
	}

	@PostMapping
	public ResponseVO register(@Valid @RequestBody EmployeeVo obj, Errors error) throws Exception {
		final ResponseVO status = new ResponseVO();
		try {
			if (error.hasErrors()) {
				status.setStatus("Enter mandatory details in valid format");

			}
			employeeService.register(obj);
			status.setStatus("success");

		} catch (final Exception c) {
			status.setStatus("Failed!");
			status.setMessage(c.getMessage());

		}
		return status;
	}

	@DeleteMapping("/{id}")
	public ResponseVO deleteUser(@PathVariable Long id) {// DELETE
		employeeService.delete(id);
		final ResponseVO status = new ResponseVO();
		status.setStatus("success");
		return status;
	}

	@GetMapping("/update/{login}")
	public List<String> disableColumns(@PathVariable Long login) {
		return employeeService.disable(login);
	}

	@PutMapping("/{id}") // update all fields
	public ResponseVO update(@PathVariable Long id, @Valid @RequestBody EmployeeVo obj, Errors error) {// PUT
		final ResponseVO status = new ResponseVO();
		try {
			if (error.hasErrors()) {
				status.setStatus("Enter mandatory details in valid format");
			}
			employeeService.update(id, obj);
			status.setStatus("success");
		} catch (final Exception c) {
			status.setStatus("Failed!");
			status.setMessage("Make sure unique constraints are followed.");
		}
		return status;
	}

	@PutMapping("delete/{id}") // status disable. maintains record
	public ResponseVO delete(@PathVariable String id) {
		employeeService.remove(id);
		final ResponseVO status = new ResponseVO();
		status.setStatus("success");
		return status;
	}
}