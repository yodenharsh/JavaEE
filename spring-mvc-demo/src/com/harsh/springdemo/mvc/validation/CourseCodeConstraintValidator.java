package com.harsh.springdemo.mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

	private String coursePrefix;
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value!=null) {
		boolean result = value.startsWith(coursePrefix);
		return result;
		}
		return false;
	}

	@Override
	public void initialize(CourseCode constraintAnnotation) {
		coursePrefix = constraintAnnotation.value();
	}
	
}
