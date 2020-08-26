package com.example.tademo.pojo.po;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@XmlRootElement(name = "application")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationPo {
	
	private String applicationId;
	
    private String applicantId;
    private String applicantName;
    private Date applicantBirthDate;
    private String applicantGender;
    private String applicantAddress;
    private String applicantPhoneNumber;
    
    private String insuredId;
    private String insuredName;
    private Date insuredBirthDate;
    private String insuredGender;
    private String insuredAddress;
    private String insuredPhoneNumber;

	private int insuranceAmount;
	private String channel;
	
	private Date dataCreatedTime;

}
