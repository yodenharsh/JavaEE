package com.harsh.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectExpressions {
	
	@Pointcut("execution(* com.harsh.aopdemo.dao.*.get*(..))")
	public void getter() {}
	
	@Pointcut("execution(* com.harsh.aopdemo.dao.*.set*(..))")	
	public void setter() {}
	
	@Pointcut("execution(* add*(com.harsh.aopdemo.Account))")
	public void forDAOPackage() {}
	
	@Pointcut("forDAOPackage() && !(getter() || setter())")
	public void forDAOPackageNoGetterSetter() {}
}
