package com.harsh.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.harsh.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	
	private static Logger myLogger = Logger.getLogger(AroundDemoApp.class.getName());
	
	public static void main(String[] args) {
		
		
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		myLogger.info("Fortune is: "+trafficFortuneService.getFortune());
		
		context.close();
	}

}
