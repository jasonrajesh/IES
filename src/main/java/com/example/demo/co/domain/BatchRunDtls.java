package com.example.demo.co.domain;

import java.util.Date;

import lombok.Data;

@Data
public class BatchRunDtls {
	
	private Integer batchrunSeq;	
	private String batchName;	
	private String batchrunStatus;	
	private Date endDate;	
	private Integer instanceNum;	
	private Date startDate;
	
}
