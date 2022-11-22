package com.harsh.airline_reservation_system_web.ui;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Map;

import com.harsh.airline_reservation_system_web.business_logic.misc.GetConnection;
import com.harsh.airline_reservation_system_web.business_logic.misc.GetCookies;
import com.harsh.airline_reservation_system_web.business_logic.operations.BookingOperationsImpl;
import com.harsh.airline_reservation_system_web.business_logic.operations.BookingOperationsInterface;
import com.harsh.airline_reservation_system_web.business_logic.records.ReservationInfo;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class NewTrips extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BookingOperationsInterface bOps;
	
	public NewTrips() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean isAuth = false;
		String email;
		Map<String, String> cookieMap = GetCookies.getCookies(request, response);
		email = cookieMap.get("email");
		isAuth = Boolean.parseBoolean(cookieMap.get("isAuth"));
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML><html><body>");
		if (!isAuth) {
			out.println("<h3>Please login first</h3>");
			out.println("<a href='./index.jsp'>Go to login page</a>");
		} else {
			out.println("<h3>" + request.getParameter("date") + "</h3>");
			LocalDate date = LocalDate.parse(request.getParameter("date"));
			ReservationInfo resInfo = new ReservationInfo(email, request.getParameter("to"),
					request.getParameter("from"), Integer.parseInt(request.getParameter("people")), date);
			bOps = new BookingOperationsImpl();
		    if(bOps.bookTicket(resInfo, GetConnection.getConnection())) {
		    	out.println("<h3>Booking successful</h3>");
		    	out.println("<a href='view-trips'>Go back</a>");
		    }
		    else {
		    	out.println("<h3>Booking unsuccessful</h3>");
		    	out.println("<a href='./newTrips.jsp'>Go back</a>");
		    }
		}
		out.println("</body></html>");
	}
	

	
}
