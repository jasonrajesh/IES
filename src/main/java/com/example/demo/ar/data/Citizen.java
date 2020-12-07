package com.example.demo.ar.data;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
@Data
public class Citizen {
	
	private Integer sno;
	private String firstName;
	private String lastName;	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dob;
	private String gender;
	private Long ssnId;
	private Integer phoneNo;
	private String email;
}
