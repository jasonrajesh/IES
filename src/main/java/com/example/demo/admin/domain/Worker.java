package com.example.demo.admin.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
@Data
public class Worker {

	private Integer sno;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dob;
	private String gender;
	private Long ssnId;
	private Integer phoneNo;
	private String role;
	
	
	
}
