package com.harsh.airline_reservation_system;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.harsh.airline_reservation_system.StartingPrograms.StartHere;
import com.harsh.airline_reservation_system.connectToDB.ConnectToDB;

public class App {
	public static void main(String[] args) throws SQLException {
		Properties info = new Properties();
		info.put("user", "root");
		info.put("password", "root");
		String url = "jdbc:mysql://localhost/reservations?autoReconnect=true";
		Connection conn = (new ConnectToDB()).connect(url, info);
		(new StartHere()).TakeUserInput(conn);
		conn.close();
	}

}