package com.harsh.springdemo.mvc;

import com.harsh.springdemo.mvc.validation.CourseCode;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Customer {
	
	private String firstName;
	
	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private String lastName;
	@CourseCode(value = "ABC", message = "Should start with ABC")
	private String courseCode;
	
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
