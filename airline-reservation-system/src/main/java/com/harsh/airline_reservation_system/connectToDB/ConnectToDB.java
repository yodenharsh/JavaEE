package com.harsh.airline_reservation_system.connectToDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectToDB implements ConnectToDBInteface {
    public Connection connect(String url, Properties info) {
    	try{
    		Connection conn = DriverManager.getConnection(url,info);
    		System.out.println("Successfully connected to the database");
    		return conn;
    	} catch(SQLException e) {
    		System.out.println("An error occurred while connecting to the database");
    		e.printStackTrace();
    		return null;
    	}
    }
}
