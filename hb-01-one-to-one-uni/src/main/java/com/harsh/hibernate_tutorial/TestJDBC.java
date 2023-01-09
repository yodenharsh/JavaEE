package com.harsh.hibernate_tutorial;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false&serverTimezone=UTC";
		String password = "root";
		String user = "root";
		try {
			
			Connection conn = DriverManager.getConnection(url,user,password);
			System.out.println(conn);
			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
