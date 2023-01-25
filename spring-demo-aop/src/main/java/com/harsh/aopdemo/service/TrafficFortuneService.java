package com.harsh.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {

	public String getFortune() {
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return "Expecting clear roads";
	}

	public String getTripwire(boolean tripwire) {
		
		if(tripwire) {
			throw new RuntimeException("Can't proceed. Major roadblock ahead.");
		}
		
		return getFortune();
	}
}