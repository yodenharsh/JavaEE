package com.harsh.airline_reservation_system_web.ui;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import com.harsh.airline_reservation_system_web.business_logic.misc.GetConnection;
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
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Connection conn = GetConnection.getConnection();
		UserInfo userInfo = new UserInfo(email, password);
		OperationsImpl bOps = new OperationsImpl();
		PrintWriter writer = response.getWriter();
		if(bOps.login(userInfo, conn)) {
			writer.println("Successfully logged in");
			try {
				Cookie emailCookie = new Cookie("email", email);
				Cookie passwordCookie = new Cookie("password",password);
				Cookie isAuthCookie = new Cookie("isAuth", "true");
				response.addCookie(isAuthCookie);
				response.addCookie(emailCookie);
				response.addCookie(passwordCookie);
				Thread.sleep(500);
				response.sendRedirect("loginConfirm.jsp");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		writer.println("<h1>Wrong Password or Email</h1>");

		writer.close();
	}
	

}
