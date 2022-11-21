package com.harsh.airline_reservation_system_web.business_logic.custom_exceptions;

public class TripIdNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public TripIdNotFoundException(String msg){
		super(msg);
	}
}
