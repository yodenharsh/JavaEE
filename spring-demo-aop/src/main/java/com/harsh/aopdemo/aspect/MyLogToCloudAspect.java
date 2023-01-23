package com.harsh.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class MyLogToCloudAspect {
	
	@Before("com.harsh.aopdemo.aspect.AspectExpressions.forDAOPackage()")
	public void logToCloud() {
		System.out.println("==========>> Log to Cloud advice executed");
	}
}
