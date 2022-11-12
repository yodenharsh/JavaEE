package com.harsh.spring_setup;

public class BaseballCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public BaseballCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes on batting practice";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	public void initMethod() {
		System.out.println("Inside intialization method");
	}
	public void destroyMethod() {
		System.out.println("Inside destroy method");
	}	
}
