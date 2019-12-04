package com.asset.management.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.asset.management.dao.entity.AssetEntity;
import com.asset.management.dao.entity.Employee;
=======
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

>>>>>>> d1f261f9c6be18d9ec7b00e4d68991921b846774
import com.asset.management.dao.entity.Login;

public interface LoginRepository extends JpaRepository<Login, Long>{

<<<<<<< HEAD

=======
>>>>>>> d1f261f9c6be18d9ec7b00e4d68991921b846774
	Login findByUsername(String username);

	@Query(value="SELECT * FROM login_details WHERE employee_id=:employeeId",nativeQuery=true)
	Login findByEmployeeId(@Param("employeeId") Long employeeId);

<<<<<<< HEAD

=======
	@Modifying
	@Query(value = "Update login_details obj set obj.username=:email where obj.employee_id=:empId", nativeQuery = true)
	void update(@Param("empId") Long empId,@Param("email") String email);
>>>>>>> d1f261f9c6be18d9ec7b00e4d68991921b846774
}
