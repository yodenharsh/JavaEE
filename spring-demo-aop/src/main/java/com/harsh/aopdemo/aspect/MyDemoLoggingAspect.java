package com.harsh.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.harsh.aopdemo.Account;
import com.harsh.aopdemo.AroundDemoApp;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {
	
	
	private Logger myLogger = Logger.getLogger(getClass().getName());

	
	@Around("execution(* com.harsh.aopdemo.service.*.*(..))")
	public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		String method = proceedingJoinPoint.getSignature().toShortString();
		myLogger.info("=======>>Execution @Around on "+method);
		
		long begin = System.currentTimeMillis();
		Object result = proceedingJoinPoint.proceed();
		
		long end = System.currentTimeMillis();
		long duration = end - begin;
		myLogger.info("Duration to execute: "+duration+" ms");
		
		return result;
	}
	
	
	@Before("com.harsh.aopdemo.aspect.AspectExpressions.forDAOPackage()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		System.out.println("=======>> Advice executed");
		
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		System.out.println("Method: " + methodSignature);
		
		Object[] args = joinPoint.getArgs();
		for(Object arg: args) {
			System.out.println(arg);
			if(arg instanceof Account) {
				
				System.out.println("Account name: "+ ((Account) arg).getName());
			}
		}
		
				
	}
	
	@AfterReturning(pointcut = "execution(* com.harsh.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
		
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n===========> Executing @AfterReturning on method: " + method);
		
		
		convertNamesToUpperCase(result);
		System.out.println("Result is: "+result);
		
	}

	private void convertNamesToUpperCase(List<Account> result) {
		
		String name;
		for(Account acc: result) {
			name = acc.getName().toUpperCase();
			acc.setName(name);
		}
	}
	
	
}
