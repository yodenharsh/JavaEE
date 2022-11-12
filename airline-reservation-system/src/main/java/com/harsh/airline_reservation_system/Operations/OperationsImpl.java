package com.harsh.airline_reservation_system.Operations;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.harsh.airline_reservation_system.UserInfo;

public class OperationsImpl implements AuthOperationsInterface {

	@Override
	public boolean login(UserInfo userInfo, Connection conn) {
		String query = "SELECT email, password FROM userList where email = '" + userInfo.email()
				+ "'and password = MD5('" + userInfo.password() + "')";
		try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
			if (rs.next())
				return true; // email password combination is present

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	@Override
	public boolean signup(UserInfo userInfo, Connection conn) {
		String emailregex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
		if (!userInfo.email().matches(emailregex))
			return false;
		String query = "SELECT email FROM userList where email = '" + userInfo.email() + "'";
		try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query);) {

			if (rs.next()) // rows were returned - email exists in database
				return false;

			query = "INSERT INTO userList VALUES ('" + userInfo.email() + "', MD5('" + userInfo.password() + "'))";
			if (stmt.executeUpdate(query) == 1)
				return true;

		} catch (SQLException e) {
			System.out.println("SQL error");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean changePassword(UserInfo userInfo, String newPassword, Connection conn) {
		String query = "UPDATE userList SET password = MD5('"+newPassword+"') WHERE email = '"+userInfo.email()+"'";
		try(Statement stmt = conn.createStatement()){
			 int affectedRows = stmt.executeUpdate(query);
			 if(affectedRows == 1) return true;
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	@Override
	public boolean forgotPassword(String email, Connection conn) {
		// TODO Auto-generated method stub
		return false;
	}

}
