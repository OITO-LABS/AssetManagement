
package com.asset.management.dao.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



import java.math.BigInteger;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "reimbursement_details")
@ToString
@Getter
@Setter
public class ReimbursementDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "track_id")
	private Long trackId;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "reimbursement_id")
	private ReimbursementTrack reimbursementTrack;

	@Column(name = "reimbursement_bill_date")
	private String billDate;

	@Column(name = "reimbursement_description")
	private String reimbursementDescription;

	@Column(name = "reimbursement_bill_no")
	private double billNo;

	@Column(name = "reimbursement_cost")
	private double cost;

	@Column(name = "category_name")
	private String categoryName;
}
