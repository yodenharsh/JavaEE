package com.harsh.airline_reservation_system_web.ui;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Properties;

import com.harsh.airline_reservation_system_web.business_logic.connectToDB.ConnectToDB;
import com.harsh.airline_reservation_system_web.business_logic.misc.GetDBDetailsFromProperties;
import com.harsh.airline_reservation_system_web.business_logic.operations.OperationsImpl;
import com.harsh.airline_reservation_system_web.business_logic.records.UserInfo;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ConfirmLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ConfirmLogin() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Connection conn = getConnection(email, password);
		UserInfo userInfo = new UserInfo(email, password);
		OperationsImpl bOps = new OperationsImpl();
		PrintWriter writer = response.getWriter();
		if(bOps.login(userInfo, conn)) {
			writer.println("Successfully logged in");
			try {
				Cookie emailCookie = new Cookie("email", email);
				Cookie isAuthCookie = new Cookie("isAuth", "true");
				response.addCookie(isAuthCookie);
				response.addCookie(emailCookie);
				Thread.sleep(500);
				response.sendRedirect("loginConfirm.jsp");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		writer.println("<h1>Wrong Password or Email</h1>");

		writer.close();
	}
	
	private static Connection getConnection(String email, String password) {
		Properties info = (new GetDBDetailsFromProperties()).getDBDetails();
		String url = info.getProperty("address") + info.getProperty("db.name") + "?autoReconnect=true";
		Connection conn = (new ConnectToDB()).connect(url, info);
		return conn;

	}

}
