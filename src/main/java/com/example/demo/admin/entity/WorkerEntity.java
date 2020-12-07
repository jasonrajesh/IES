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
@Table(name="WORKER")
public class WorkerEntity {

	@Id
	@GeneratedValue
	private Integer sno;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	@Temporal(TemporalType.DATE)
	private Date dob;
	private String gender;
	private Long ssnId;
	private Integer phoneNo;
	private String role;
	private String accStatus;
	
	
	
}
