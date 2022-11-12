package com.harsh.airline_reservation_system.Operations;

import java.sql.Connection;
import java.util.Random;
import java.sql.ResultSet;

import com.harsh.airline_reservation_system.ReservationInfo;

public class BookingOperationsImpl implements BookingOperationsInterface {

	@Override
	public boolean bookTicket(ReservationInfo reservationInfo, Connection conn) {
		int year = reservationInfo.date().getYear();
		int month = reservationInfo.date().getMonthValue();
		int dayOfMonth = reservationInfo.date().getDayOfMonth();
		int tripId = Math.abs((new Random()).nextInt());

		String query = "INSERT INTO reservationsList VALUES(" + tripId + ",'" + reservationInfo.email() + "','"
				+ reservationInfo.to() + "','"+reservationInfo.from()+"',"+reservationInfo.people();
		return false;
	}

	@Override
	public boolean cancelReservation(long tripID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ResultSet getReservations(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
