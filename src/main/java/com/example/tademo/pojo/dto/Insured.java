package com.example.tademo.pojo.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Insured {
	
    private String insuredId;
    private String insuredName;
    private Date insuredBirthDate;
    private String insuredGender;
    private String insuredAddress;
    private String insuredPhoneNumber;

}
