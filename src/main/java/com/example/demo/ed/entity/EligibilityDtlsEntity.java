package com.example.demo.ed.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "ELIGIBILITY_DETAILS")
public class EligibilityDtlsEntity {
	@Id
	@GeneratedValue
	@Column(name = "ED_TRACE_ID")
	private Integer edtraceId;
	@Column(name = "BENIFIT_AMOUNT")
	private String benifitAmount;
	@Column(name = "CASE_NUM")
	private Integer caseNum;
	@Column(name = "CREATE_DT")
	private Date createDt;
	@Column(name = "DENIAL_REASON")
	private String denialReason;
	@Column(name = "PLAN_END_DT")
	private String planendDt;
	@Column(name = "PLAN_NAME")
	private String planName;
	@Column(name = "PLAN_START_DT")
	private String planstartDt;
	@Column(name = "PLAN_STATUS")
	private String planStatus;
	@Column(name = "UPDATE_DT")
	private Date updateDt;

}
