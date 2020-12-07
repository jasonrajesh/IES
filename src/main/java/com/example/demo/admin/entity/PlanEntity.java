package com.example.demo.admin.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name = "PLANS")
public class PlanEntity {

	@Id
	@GeneratedValue
	private Integer pid;
	private String pname;
	private String pdesc;
	@Temporal(TemporalType.DATE)
	private Date sdate;
	@Temporal(TemporalType.DATE)
	private Date edate;
	
}
