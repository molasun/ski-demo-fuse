package com.example.tademo.router;

import javax.xml.bind.JAXBContext;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.tademo.pojo.common.BaseInputDto;
import com.example.tademo.pojo.po.ApplicationPo;
import com.example.tademo.processor.InputTransformProcesscor;
import com.example.tademo.processor.TaApplicationDataProcessor;

@Component
public class TaBackendRouter extends RouteBuilder{
	
	@Value("${backend.service-url}")
	String serviceUrl;

	@Override
	public void configure() throws Exception {
		
		// XML Data Format
		JaxbDataFormat xmlDataFormat = new JaxbDataFormat();
		JAXBContext context = JAXBContext.newInstance(ApplicationPo.class);
		xmlDataFormat.setContext(context);

		// JSON Data Format
		JacksonDataFormat jsonDataFormat = new JacksonDataFormat(BaseInputDto.class);
		
		// Call BE
		from("jms:queue:application.approved")
		  .log("data is ${body}")
		  .unmarshal(jsonDataFormat)
		  .process(new InputTransformProcesscor())
		  .process(new TaApplicationDataProcessor())
		  .marshal(xmlDataFormat)
		.doTry()
		   .log("data is ${body}")
		   .to(serviceUrl + "/toBackend?httpMethod=POST")
		   .log("===To BE Route===")
		.doCatch(Exception.class)
		   .log("===To Retry Route===")
		   .to("jms:queue:RETRY")
		.endDoTry()
		  .end();
		
	}
	
}
