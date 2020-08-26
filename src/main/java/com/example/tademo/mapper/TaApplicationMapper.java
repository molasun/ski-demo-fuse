package com.example.tademo.mapper;

import com.example.tademo.pojo.dto.ApplicationDto;
import com.example.tademo.pojo.po.ApplicationPo;

public class TaApplicationMapper {
	
	public static ApplicationPo toPo(ApplicationDto dto) {
		
		ApplicationPo application = new ApplicationPo();
		
		application.setApplicationId(dto.getId());
		
		application.setApplicantId(dto.getApplicant().getApplicantId());
		application.setApplicantName(dto.getApplicant().getApplicantName());
		application.setApplicantBirthDate(dto.getApplicant().getApplicantBirthDate());
		application.setApplicantGender(dto.getApplicant().getApplicantGender());
		application.setApplicantAddress(dto.getApplicant().getApplicantAddress());
		application.setApplicantPhoneNumber(dto.getApplicant().getApplicantPhoneNumber());
		
		application.setInsuredId(dto.getInsured().getInsuredId());
		application.setInsuredName(dto.getInsured().getInsuredName());
		application.setInsuredBirthDate(dto.getInsured().getInsuredBirthDate());
		application.setInsuredGender(dto.getInsured().getInsuredGender());
		application.setInsuredAddress(dto.getInsured().getInsuredAddress());
		application.setInsuredPhoneNumber(dto.getInsured().getInsuredPhoneNumber());
		
		application.setInsuranceAmount(dto.getInsuranceAmount());
		application.setChannel(dto.getChannel());
		
		return application;
	}

}
