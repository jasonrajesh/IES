package com.example.demo.admin.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
@Data
public class Plan {

	private Integer pid;
	private String pname;
	private String pdesc;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date sdate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date edate;
}
