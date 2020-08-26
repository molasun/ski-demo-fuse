package com.example.tademo.pojo.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Applicant {
	
    private String applicantId;
    private String applicantName;
    private Date applicantBirthDate;
    private String applicantGender;
    private String applicantAddress;
    private String applicantPhoneNumber;

}
