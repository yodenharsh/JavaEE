package com.harsh.airline_reservation_system_web.business_logic.connectToDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectToDB implements ConnectToDBInteface {
    public Connection connect(String url, Properties info) {
    	try{
    		Class.forName("com.mysql.jdbc.Driver");
    		Connection conn = DriverManager.getConnection(url,info);	
    		return conn;
    	} catch(SQLException e) {
    		System.out.println("An error occurred while connecting to the database");
    		e.printStackTrace();
    		return null;
    	} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return null;
    }
}
