package com.harsh.actalyst_webapp.entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Contains the current user's details
 * @author yodenharsh
 *
 */
public class UserDetails {
	
	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private String name;
	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dob;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
}
