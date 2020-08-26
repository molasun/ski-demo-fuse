package com.example.tademo.pojo.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationDto {
	
	private String id;
	
	private Applicant applicant;
	private Insured insured;
	
	private int insuranceAmount;
	private String channel;
	
	private Date applyTime;
	private Date modifyTime;
	private Date rejectTime;
	private Date approvedTime;
	
	private String status;

}
