package com.harsh.airline_reservation_system_web.ui;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import com.harsh.airline_reservation_system_web.business_logic.misc.GetConnection;
import com.harsh.airline_reservation_system_web.business_logic.operations.AuthOperationsInterface;
import com.harsh.airline_reservation_system_web.business_logic.operations.OperationsImpl;
import com.harsh.airline_reservation_system_web.business_logic.records.UserInfo;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AuthOperationsInterface ops;


	public Signup() {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ops = new OperationsImpl();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		UserInfo userInfo = new UserInfo(email, password);
		Connection conn = GetConnection.getConnection();
		PrintWriter out = response.getWriter();
		if (ops.signup(userInfo, conn)) {
			out.println("<!DOCTYPE html><html><h2>Signed up successfully</h2>");
		} else {
			out.println("<!DOCTYPE html><html><h2>Signup failed. Email already exists or is invalid</h2>");
		}
		out.println("<a href = './index.jsp'>Go back</a></html>");
	}

}
