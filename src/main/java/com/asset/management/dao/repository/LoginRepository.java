package com.asset.management.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.asset.management.dao.entity.AssetEntity;
import com.asset.management.dao.entity.Employee;
import com.asset.management.dao.entity.Login;

public interface LoginRepository extends JpaRepository<Login, Long>{


	Login getByEmployee(Employee employee);

	Login findByUsername(String username);

	@Query(value="SELECT * FROM login_details WHERE employee_id=:employeeId",nativeQuery=true)
	Login findByEmployeeId(@Param("employeeId") Long employeeId);
}
