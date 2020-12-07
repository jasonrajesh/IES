package com.example.demo.ar.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
public class CitizenEntity {

	@Id
	@GeneratedValue
	private Integer sno;
	private String firstName;
	private String lastName;
	@Temporal(TemporalType.DATE)
	private Date dob;
	private String gender;
	private Long ssnId;
	private Integer phoneNo;
	private String email;
	
	
}
