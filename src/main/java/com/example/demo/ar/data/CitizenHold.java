package com.example.demo.ar.data;

import java.util.Date;

import lombok.Data;

@Data
public class CitizenHold {

	private String dob;
	private String firstName;
	private String gender;
	private String lastName;
	private Integer ssnId;
	private String state;
	
	private String errCode;
	private String errMsg;
	private Date date;
	
}
