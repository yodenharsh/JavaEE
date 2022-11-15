package com.harsh.airline_reservation_system.Operations;

import java.sql.Connection;
import java.sql.ResultSet;

import com.harsh.airline_reservation_system.ReservationInfo;
import com.harsh.airline_reservation_system.CustomExceptions.NoTripsFoundException;
import com.harsh.airline_reservation_system.CustomExceptions.TripIdNotFoundException;

public interface BookingOperationsInterface {
	public boolean bookTicket(ReservationInfo reservationInfo, Connection conn);
	public boolean cancelReservation(int tripID, String email, Connection conn) throws TripIdNotFoundException;
	public ResultSet getReservations(String email, Connection conn) throws NoTripsFoundException;
	public void viewTrips(ResultSet tripsList);
}
