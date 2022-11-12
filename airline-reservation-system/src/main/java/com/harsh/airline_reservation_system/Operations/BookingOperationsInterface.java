package com.harsh.airline_reservation_system.Operations;

import java.sql.Connection;
import java.sql.ResultSet;

import com.harsh.airline_reservation_system.ReservationInfo;

public interface BookingOperationsInterface {
	public boolean bookTicket(ReservationInfo reservationInfo, Connection conn);
	public boolean cancelReservation(long tripID);
	public ResultSet getReservations(String email);
}
