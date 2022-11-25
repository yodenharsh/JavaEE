package com.harsh.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach theCoach = context.getBean("TheSillyCoach", Coach.class);
		Coach alphaCoach = context.getBean("TheSillyCoach", Coach.class);
		
		boolean result = (theCoach == alphaCoach);
		System.out.println("Is same: "+result);
		System.out.println("Memory loc of theCoach: "+theCoach);
		System.out.println("Memory loc of theCoach: "+alphaCoach);
		
		context.close();
	}

}
