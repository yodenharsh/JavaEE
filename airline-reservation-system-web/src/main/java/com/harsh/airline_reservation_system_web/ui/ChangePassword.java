package com.harsh.airline_reservation_system_web.ui;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Map;

import com.harsh.airline_reservation_system_web.business_logic.misc.GetConnection;
import com.harsh.airline_reservation_system_web.business_logic.misc.GetCookies;
import com.harsh.airline_reservation_system_web.business_logic.operations.AuthOperationsInterface;
import com.harsh.airline_reservation_system_web.business_logic.operations.OperationsImpl;
import com.harsh.airline_reservation_system_web.business_logic.records.UserInfo;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AuthOperationsInterface ops;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean isAuth = false;
		String email, password;
		Map<String, String> cookieMap = GetCookies.getCookies(request, response);
		isAuth = Boolean.parseBoolean(cookieMap.get("isAuth"));
		email = cookieMap.get("email");
		password = cookieMap.get("password");
		String newPassword = request.getParameter("new-password");
		PrintWriter out = response.getWriter();
		UserInfo userInfo = new UserInfo(email, password);
		out.println("<!DOCTYPE html><html><body>");
		if(!isAuth) {
			out.println("<h3>Cannot change password without logging in</h3>");
			out.println("<a href='./index.jsp'>Go back</a>");
		} else {
			Connection conn = GetConnection.getConnection();
			ops = new OperationsImpl();
			if(ops.changePassword(userInfo, newPassword, conn)) {
				out.println("<h3>Password changed</h3>");
				out.println("<a href='./index.jsp'>Go back</a>");
			}
			else {
				out.println("<h3>Password cannot be changed due to internal server error</h3>");
				out.println("<a href='./changePassword.jsp'>Try again</a>");
			}
		}
		out.println("</body></html>");
		
	}

}
