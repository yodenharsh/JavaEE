package com.harsh.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	@Before("execution(public void com.harsh.aopdemo.dao.MembershipDAO.add*())")
	public void beforeAddAccountAdvice() {
		System.out.println("=======>> Advice executed");
	}
	
}
