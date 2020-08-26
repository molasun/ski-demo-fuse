package com.example.tademo.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.example.tademo.pojo.common.BaseInputDto;
import com.example.tademo.pojo.dto.ApplicationDto;
import com.fasterxml.jackson.databind.ObjectMapper;

public class InputTransformProcesscor implements Processor{
	
	@Override
	public void process(Exchange exchange) throws Exception {
		
		BaseInputDto inputDto = exchange.getIn().getBody(BaseInputDto.class);
		String applicationData = inputDto.getData();
		
		ObjectMapper mapper = new ObjectMapper();	
		ApplicationDto applicationDto = mapper.readValue(applicationData, ApplicationDto.class);
		
		exchange.getOut().setBody(applicationDto);
		
	}

}
