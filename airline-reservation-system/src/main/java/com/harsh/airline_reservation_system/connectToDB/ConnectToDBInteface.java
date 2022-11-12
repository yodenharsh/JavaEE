package com.harsh.airline_reservation_system.connectToDB;

import java.sql.Connection;
import java.util.Properties;

public interface ConnectToDBInteface {
	public Connection connect(String url, Properties info);
}
