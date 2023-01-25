package com.harsh.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.harsh.aopdemo.service.TrafficFortuneService;



public class AroundExceptionHandleDemoApp {
	private static Logger myLogger = Logger.getLogger(AroundDemoApp.class.getName());
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		boolean tripwire = true;
		String data = trafficFortuneService.getTripwire(tripwire);
		
		myLogger.info("Fortune is: "+data);
		
		context.close();
	}
	
}
