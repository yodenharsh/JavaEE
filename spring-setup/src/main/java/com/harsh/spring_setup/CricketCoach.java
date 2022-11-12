package com.harsh.spring_setup;

public class CricketCoach implements Coach{

	private FortuneService fortuneService;
	private String email;
	private String team;
	
	@Override
	public String getDailyWorkout() {
		return "Practice fast bowling";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	
	public CricketCoach() {
		System.out.println("Cricket coach is inside the no-args constructor");
	}

	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Inside setter method");
		this.fortuneService = fortuneService;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		System.out.println("Inside setEmail setter method");
		this.email = email;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("Inside setTeam setter method");
		this.team = team;
	}
	
	
}
