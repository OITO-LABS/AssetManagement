package com.asset.management.dao.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.asset.management.dao.entity.ReimbursementDetails;

public interface ReimbursementRepository extends JpaRepository<ReimbursementDetails, Long> {

	@Query(value = "select * from reimbursement_details", nativeQuery = true)
	List<ReimbursementDetails> selectReimbursementDetails();

	@Query(value = "SELECT * FROM reimbursement_details u WHERE u.reimbursement_id = :reimbursementId", nativeQuery = true)
	List<Object[]> findByReimbursementTrack(@Param("reimbursementId") Long reimbursementId);

	@Query(value = "select r.* from reimbursement_details r where r.reimbursement_id in(select t.reimbursement_id from reimbursement_track t where t.emp_no=:empNo)", nativeQuery = true)
	List<Object[]> findByReimbursementEmpNo(@Param("empNo") String empNo);

	@Query(value = "SELECT * FROM reimbursement_details u WHERE u.reimbursement_bill_no = :billNo", nativeQuery = true)
	ReimbursementDetails findByReimbursementBillNo(@Param("billNo") BigInteger billNo);
	
}
