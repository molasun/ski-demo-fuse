package com.example.tademo.processor;

import java.util.Date;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.example.tademo.mapper.TaApplicationMapper;
import com.example.tademo.pojo.dto.ApplicationDto;
import com.example.tademo.pojo.po.ApplicationPo;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TaApplicationDataProcessor implements Processor{

	@Override
	public void process(Exchange exchange) throws Exception {
		
		ApplicationDto dto = exchange.getIn().getBody(ApplicationDto.class);
		
		ApplicationPo applicationPo = TaApplicationMapper.toPo(dto);
		
		applicationPo.setDataCreatedTime(new Date());
		exchange.getOut().setBody(applicationPo);
		
	}	

}
