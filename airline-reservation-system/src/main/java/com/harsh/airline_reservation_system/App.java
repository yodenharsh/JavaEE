package com.harsh.airline_reservation_system;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.harsh.airline_reservation_system.StartingPrograms.StartHere;
import com.harsh.airline_reservation_system.connectToDB.ConnectToDB;

public class App {
	public static void main(String[] args) throws SQLException {
		Properties info = getDBDetails();
		String url = info.getProperty("address") + info.getProperty("db.name") + "?autoReconnect=true";
		Connection conn = (new ConnectToDB()).connect(url, info);
		(new StartHere()).TakeUserInput(conn);
		conn.close();
	}
	
	private static Properties getDBDetails() {
		try(InputStream iStream = new FileInputStream("db.properties")){
			Properties p = new Properties();
			p.load(iStream);
			return p;
		} catch(IOException e) {
			System.out.println("File couldn't be loaded or doesn't exist");
			return null;
		}
	}
}