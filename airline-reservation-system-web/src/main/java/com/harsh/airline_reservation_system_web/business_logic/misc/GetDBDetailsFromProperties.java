package com.harsh.airline_reservation_system_web.business_logic.misc;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

public class GetDBDetailsFromProperties {
	public Properties getDBDetails() {
		//try(InputStream iStream = new FileInputStream("/airline-reservation-system-web/src/main/resources/db.properties")){
		String filePath = Objects.requireNonNull(getClass().getClassLoader().getResource("db.properties")).getPath();
		try(InputStream iStream = new FileInputStream(filePath)){
			Properties p = new Properties();
			p.load(iStream);
			return p;
		} catch(IOException e) {
			System.out.println("File couldn't be loaded or doesn't exist");
			return null;
		}
	}
}
