package com.harsh.spring_setup;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;
	
	TrackCoach(){
		System.out.println("Default constructor here");
	}
	
	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Run hard 5k";
	}

	@Override
	public String getDailyFortune() {
		return "No, "+fortuneService.getFortune();
	}
	
}
