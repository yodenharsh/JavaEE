package com.harsh.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.harsh.aopdemo.Account;

@Component
public class AccountDAO {
	
	public void addAccount(Account account) {
		System.out.println(getClass() + " is executed");
	}
}
