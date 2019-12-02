package com.asset.management.dao.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.asset.management.dao.entity.Employee;
import com.asset.management.dao.entity.Status;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Employee findByEmpNo(String empNo);

	@Query(value = "select * from employee_details employeeobj where employeeobj.enable_status=:status ORDER BY employeeobj.emp_no ASC", nativeQuery = true)
	Page<Employee> findE(@Param("status") String status, Pageable pageable);

	@Modifying
	@Query(value = "Update employee_details employeeobj set employeeobj.emp_no=:empNo,employeeobj.emp_fname=:firstName,employeeobj.emp_lname=:lastName,employeeobj.designation=:designation,employeeobj.email=:email,employeeobj.mobile_no=:contactNo,employeeobj.date_of_birth=:dob,employeeobj.emergency_contact_name=:emergencyContactName,employeeobj.emergency_contact_no=:emergencyContact,employeeobj.health_card_no=:healthCardNo,employeeobj.blood_group=:bloodGroup where employeeobj.emp_id=:empId", nativeQuery = true)
	void update(@Param("empId") Long empId, @Param("firstName") String firstName, @Param("lastName") String lastName,
			@Param("designation") String designation, @Param("email") String email, @Param("contactNo") String string,
			@Param("dob") String dob, @Param("emergencyContactName") String emergencyContactName,
			@Param("emergencyContact") String string2, @Param("healthCardNo") String healthCardNo,
			@Param("bloodGroup") String bloodGroup, @Param("empNo") String empNo);

	@Query(value = "select * from employee_details where enable_status=:status", nativeQuery = true)
	List<Employee> getEmpNo(@Param("status") String status);

	Employee findByEmail(String email);

	Employee findByContactNo(String contactNo);

	Employee findByHealthCardNo(String healthCardNo);

	@Query(value = "select * from employee_details emp where emp_fname like %?1% or emp_no like %?1% or email like %?1%", nativeQuery = true)
	Page<Employee> searchEmployee(Optional<String> searchkey, Pageable pageable);
}
