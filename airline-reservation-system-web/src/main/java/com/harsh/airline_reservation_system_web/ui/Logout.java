package com.harsh.airline_reservation_system_web.ui;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public Logout() {
	}


	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie cookie = null;
		Cookie[] cookies = null;

		cookies = request.getCookies();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE HTML> <html> <head><title>Logging out</title></head>");
		for (int i = 0; i < cookies.length; i++) {
			cookie = cookies[i];

			if ((cookie.getName()).compareTo("isAuth") == 0) {
				cookie.setMaxAge(0);
				response.addCookie(new Cookie("isAuth", "false"));
			}

		}
		out.println("<body><h1>Logged out successfully</h1></body>");
		out.println("<a href='index.jsp'>Go back</a>");
	}
}
