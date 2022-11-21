package com.harsh.airline_reservation_system_web.business_logic.operations;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.jasypt.util.password.BasicPasswordEncryptor;

import com.harsh.airline_reservation_system_web.business_logic.records.UserInfo;

public class OperationsImpl implements AuthOperationsInterface {

	@Override
	public boolean login(UserInfo userInfo, Connection conn) {
		String query = "SELECT email, password FROM userList where email = '" + userInfo.email() + "'";
		try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
			if (rs.next()) {
				String encPswd = rs.getString("password");
				boolean samePswd = checkPassword(encPswd, userInfo.password());
				if (samePswd)
					return true;
			}

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
			String encryptedPassword = getEncrypted(userInfo.password());

			query = "INSERT INTO userList VALUES ('" + userInfo.email() + "', '" + encryptedPassword + "')";
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
		String encryptedPassword = getEncrypted(newPassword);
		String query = "UPDATE userList SET password = '" + encryptedPassword + "' WHERE email = '" + userInfo.email()
				+ "'";
		try (Statement stmt = conn.createStatement()) {
			int affectedRows = stmt.executeUpdate(query);
			if (affectedRows == 1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	@Override
	public boolean forgotPassword(String email, Connection conn) {
		System.out.println("Please check your inbox for a changing password, " + email);
		return false;
	}

	private static String getEncrypted(String str) {
		BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
		String encryptedPassword = passwordEncryptor.encryptPassword(str);
		System.out.println(encryptedPassword);
		return encryptedPassword;
	}

	private static boolean checkPassword(String encPassword, String enteredPassword) {
		BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
		return passwordEncryptor.checkPassword(enteredPassword, encPassword);
	}

}
