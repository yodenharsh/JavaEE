package com.harsh.airline_reservation_system_web.business_logic.operations;

import java.sql.Connection;

import com.harsh.airline_reservation_system_web.business_logic.records.UserInfo;

public interface AuthOperationsInterface {
	public boolean login(UserInfo userInfo, Connection conn);
	public boolean signup(UserInfo userInfo, Connection conn);
	public boolean changePassword(UserInfo userInfo, String newPassword, Connection conn);
	public boolean forgotPassword(String email, Connection conn);
}
