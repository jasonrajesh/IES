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
@Table(name = "CO_TRIGGERS")
public class CotriggersEntity {

	@Id
	@GeneratedValue
	@Column(name = "TRG_ID")
	private String trgId;
	@Column(name = "CASE_NUM")
	private Integer caseNum;
	@Column(name = "CREATE_DT")
	private Date createDt;
	@Column(name = "TRG_STATUS")
	private String trgStatus;
	@Column(name = "UPDATE_DT")
	private Date updateDt;

}
