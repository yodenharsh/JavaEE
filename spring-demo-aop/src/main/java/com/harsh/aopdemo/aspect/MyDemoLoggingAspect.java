package com.harsh.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {
	
	@Before("com.harsh.aopdemo.aspect.AspectExpressions.forDAOPackage()")
	public void beforeAddAccountAdvice() {
		System.out.println("=======>> Advice executed");
	}
	
}
