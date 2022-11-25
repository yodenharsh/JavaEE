package com.harsh.springdemo;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component("TheSillyCoach") //If ("TheSillyCoach") is not given, the default bean ID is tennisCoach
//@Scope("prototype")//default is singleton i.e. same instance and memory loc
public class TennisCoach implements Coach {

	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println("TennisCoach -> inside doMyStartupStuff");
	}
	
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println("TennisCoach -> inside doMyCleanupsStuff");
	}
	
	public String getDailyWorkout() {
		return "Practice backhand volley";
	}

}
