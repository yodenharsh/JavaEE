package com.harsh.airline_reservation_system.CustomExceptions;

public class NoTripsFoundException extends Exception{
	private static final long serialVersionUID = 1L;

	public NoTripsFoundException(String msg) {
		super(msg);
	}
}
