package com.harsh.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.harsh.aopdemo.Account;

@Component
public class AccountDAO {
	
	public void addAccount(Account account) {
		System.out.println(getClass() + " is executed");
	}
	
	public List<Account> findAccounts() {
		List<Account> accounts = new ArrayList<>();
		
		//sample accounts
		
		Account tempAcc1 = new Account("Harsh", "Morayya");
		Account tempAcc2 = new Account("God", "Way");
		Account tempAcc3 = new Account("Robin", "Dabank");
		
		accounts.add(tempAcc3);
		accounts.add(tempAcc2);
		accounts.add(tempAcc1);
		
		return accounts;
	}
}
