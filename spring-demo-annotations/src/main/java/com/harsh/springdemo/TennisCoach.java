package com.harsh.springdemo;

import org.springframework.stereotype.Component;

@Component("TheSillyCoach") //If ("TheSillyCoach") is not given, the default bean ID is tennisCoach
public class TennisCoach implements Coach {

	public String getDailyWorkout() {
		return "Practice backhand volley";
	}

}
