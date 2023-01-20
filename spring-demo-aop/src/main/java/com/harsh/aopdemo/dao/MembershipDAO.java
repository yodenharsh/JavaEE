package com.harsh.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public void addAccount() {
		
		System.out.println(getClass() + " was called");
	}
	
	public void addSpan() {
		System.out.println(getClass() + " is adding span");
	}
}
