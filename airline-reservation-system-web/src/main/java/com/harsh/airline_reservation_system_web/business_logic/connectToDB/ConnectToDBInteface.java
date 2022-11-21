package com.harsh.airline_reservation_system_web.business_logic.connectToDB;

import java.sql.Connection;
import java.util.Properties;

public interface ConnectToDBInteface {
	public Connection connect(String url, Properties info);
}
