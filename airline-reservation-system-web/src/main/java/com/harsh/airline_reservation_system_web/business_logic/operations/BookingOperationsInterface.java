package com.harsh.airline_reservation_system_web.business_logic.operations;

import java.sql.Connection;
import java.sql.ResultSet;

import com.harsh.airline_reservation_system_web.business_logic.custom_exceptions.NoTripsFoundException;
import com.harsh.airline_reservation_system_web.business_logic.custom_exceptions.TripIdNotFoundException;
import com.harsh.airline_reservation_system_web.business_logic.records.ReservationInfo;

public interface BookingOperationsInterface {
	public boolean bookTicket(ReservationInfo reservationInfo, Connection conn);
	public boolean cancelReservation(int tripID, String email, Connection conn) throws TripIdNotFoundException;
	public ResultSet getReservations(String email, Connection conn) throws NoTripsFoundException;
	public void viewTrips(ResultSet tripsList);
}
