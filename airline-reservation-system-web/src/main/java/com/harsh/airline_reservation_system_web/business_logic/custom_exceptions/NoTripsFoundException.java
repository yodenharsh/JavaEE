package com.harsh.airline_reservation_system_web.business_logic.custom_exceptions;

public class NoTripsFoundException extends Exception{
	private static final long serialVersionUID = 1L;

	public NoTripsFoundException(String msg) {
		super(msg);
	}
}
