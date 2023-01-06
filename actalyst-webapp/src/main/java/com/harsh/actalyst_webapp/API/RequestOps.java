package com.harsh.actalyst_webapp.API;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Period;

public class RequestOps {

	/**
	 * Calculates age from given LocalDate
	 * 
	 * @param DOB as LocalDate object
	 * @return age in dd/mm/yy format
	 */
	public static String calcAge(LocalDate dob) {
		Period intervalPeriod = Period.between(dob, LocalDate.now());
		
		return
				String.valueOf(intervalPeriod.getDays()) + " days, " +
				String.valueOf(intervalPeriod.getMonths()) + " months, " +
				String.valueOf(intervalPeriod.getYears()) + " years";
	}

	/**
	 * If request was successfully added, returns 1 else 0
	 * 
	 * @param DOB
	 * @return 1 or 0
	 */
	public static int addRequests(LocalDate dob) {
		Connection conn = getConnection();
		String query = "INSERT INTO requests(dob) VALUES('"+ java.sql.Date.valueOf(dob) +"');";
		try {
			Statement stmt = conn.createStatement();
			return stmt.executeUpdate(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;

	}

	/**
	 * Checks how many requests were made through the website
	 * 
	 * @return true if more than 500 else false
	 */
	public static boolean is500OrMore() {
		Connection conn = getConnection();
		String query = "SELECT COUNT(*) AS total FROM requests";
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			if (rs.getInt("total") >= 500)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	private static String dbName = "actalyst";
	private static String username = "root";
	private static String password = "root";

	private static Connection getConnection() {
		Connection conn;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		String url = "jdbc:mysql://localhost:3306/" + dbName + "?useSSL=false&serverTimezone=UTC";
		try {
			conn = DriverManager.getConnection(url, username, password);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
