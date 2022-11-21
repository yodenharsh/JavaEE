package com.harsh.airline_reservation_system_web.business_logic.operations;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.harsh.airline_reservation_system_web.business_logic.custom_exceptions.NoTripsFoundException;
import com.harsh.airline_reservation_system_web.business_logic.custom_exceptions.TripIdNotFoundException;
import com.harsh.airline_reservation_system_web.business_logic.records.ReservationInfo;

public class BookingOperationsImpl implements BookingOperationsInterface {

	@Override
	public boolean bookTicket(ReservationInfo reservationInfo, Connection conn) {
		int year = reservationInfo.date().getYear();
		int month = reservationInfo.date().getMonthValue();
		int dayOfMonth = reservationInfo.date().getDayOfMonth();
		int tripId = Math.abs((new Random()).nextInt());

		String query = "INSERT INTO reservationsList VALUES(" + tripId + ",'" + reservationInfo.email() + "','"
				+ reservationInfo.to() + "','" + reservationInfo.from() + "'," + reservationInfo.people() + ",'" + year
				+ "-" + month + "-" + dayOfMonth + "')";

		try (Statement stmt = conn.createStatement()) {
				if(stmt.executeUpdate(query) == 1)
					return true;
		} catch (SQLException e) {
			System.out.println("Internal server error");
			e.printStackTrace();
			return false;
		}

		return false;
	}

	@Override
	public boolean cancelReservation(int tripId,String email, Connection conn) throws TripIdNotFoundException {
		String deleteQuery = "DELETE FROM reservationsList WHERE tripId = "+tripId+" AND email = '"+email+"'" ;
		try(Statement stmt = conn.createStatement()) {
			int rowsAffected = stmt.executeUpdate(deleteQuery);
			if(rowsAffected == 0)
				throw new TripIdNotFoundException("The TripID is invalid");
			return true;
		} catch (SQLException e) {
			System.out.println("Internal SQL error");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ResultSet getReservations(String email, Connection conn) throws NoTripsFoundException {
		String query = "SELECT * FROM reservationsList WHERE email = '"+ email + "'";
		try{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			if(rs.equals(null) || !rs.next())
				throw new NoTripsFoundException(query);
			else {
				return rs;
			}
		} catch(SQLException e) {
			System.out.println("Internal SQL error");
			e.printStackTrace();
		}
		catch(NoTripsFoundException e) {
			throw new NoTripsFoundException("No flight trips were booked with this account");
		}
		catch(Exception e) {
			System.out.println("Internal servel error");
		}
		return null; //Should be unreachable, I think
	}


	@Override
	public void viewTrips(ResultSet tripsList) {
		String[] tripHeaders = {"Flight Trip ID","Destination","Boarding Point","People","Date (YYYY-MM-DD)"};
		List<List<String>> list = new ArrayList<>();
		try {
			do {
				List<String> trip = new ArrayList<>();
				trip.add(String.valueOf(tripsList.getInt("tripId")));
				trip.add(tripsList.getString("toWhere"));
				trip.add(tripsList.getString("fromWhere"));
				trip.add(String.valueOf(tripsList.getInt("people")));
				trip.add(String.valueOf(tripsList.getDate("date")));
				list.add(trip);
			} while((tripsList.next()));
			String[][] tripArray = list.stream()
	                .map(l -> l.toArray(new String[l.size()]))
	                .toArray(String[][]::new);
		} catch (SQLException e) {
			System.out.println("Internal SQL error");
			e.printStackTrace();
		}
		
		
	}

}
