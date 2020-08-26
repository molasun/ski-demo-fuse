package com.example.tademo.router;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TaRetryRouter extends RouteBuilder{
	
	@Value("${backend.service-url}")
	String serviceUrl;
	
	@Override
	public void configure() throws Exception {
					
		// loop
		from("jms:queue:RETRY")
		   .routeId("retryRoute")
		   .setHeader("loopCode").constant(1)
		   .setProperty("rawData", simple("${body}"))
		   .log("loopCode Header is ${header.loopCode}")
		   .loopDoWhile()
		       .simple("${header.loopCode} == 1")
		       .doTry()
		       .log("data is ${exchangeProperty.rawData}")
		         .to(serviceUrl + "/hctest?httpMethod=POST").routeId("heaclthCheckRoute")
		         .log("data is ${body}")
		         .choice()
		            .when()
		               .simple("${header.CamelHttpResponseCode} == 200")
		               .setHeader("loopCode").constant(0)
		         .endDoTry()
		       .doCatch(Exception.class)
		       .end()
		   .end()
		   .setBody(simple("${exchangeProperty.rawData}"))
		   .log("data is ${body}")
		   .to(serviceUrl + "/toBackend?httpMethod=POST");

	}

}
