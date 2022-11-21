package com.harsh.airline_reservation_system_web.business_logic.misc;

import java.sql.Connection;
import java.util.Properties;

import com.harsh.airline_reservation_system_web.business_logic.connectToDB.ConnectToDB;

public class GetConnection {
	public static Connection getConnection() {
		Properties info = (new GetDBDetailsFromProperties()).getDBDetails();
		String url = info.getProperty("address") + info.getProperty("db.name") + "?autoReconnect=true";
		Connection conn = (new ConnectToDB()).connect(url, info);
		return conn;
	}
}
