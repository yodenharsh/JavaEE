package com.harsh.spring_setup;

public class MyApp {
	public static void main(String[] args) {
		Coach theCoach = new TrackCoach();
		System.out.println(theCoach.getDailyWorkout());
	}
}
