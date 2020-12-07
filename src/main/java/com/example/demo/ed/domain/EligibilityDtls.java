package com.example.demo.ed.domain;

import java.util.Date;

import lombok.Data;

@Data
public class EligibilityDtls {

	
	private Integer edtraceId;	
	private String benifitAmount;	
	private Integer caseNum;	
	private Date createDt;	
	private String denialReason;	
	private String planendDt;	
	private String planName;	
	private String planstartDt;	
	private String planStatus;	
	private Date updateDt;

	
}
