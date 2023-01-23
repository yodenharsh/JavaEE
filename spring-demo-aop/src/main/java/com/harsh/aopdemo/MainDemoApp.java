package com.harsh.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.harsh.aopdemo.dao.AccountDAO;
import com.harsh.aopdemo.dao.MembershipDAO;

public class MainDemoApp {
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		
		AccountDAO accountDAO = context.getBean("accountDAO",AccountDAO.class);
		MembershipDAO membershipDAO = context.getBean("membershipDAO",MembershipDAO.class);
		
		Account acc = new Account();
		acc.setLevel("HR");
		acc.setName("Harsh");
		
		accountDAO.addAccount(acc);
		membershipDAO.addAccount();
		membershipDAO.addSpan();
		
		context.close();
		
	}
}
