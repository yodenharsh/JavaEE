package com.harsh.airline_reservation_system_web.ui;

import java.io.IOException;
import java.util.Map;

import com.harsh.airline_reservation_system_web.business_logic.custom_exceptions.TripIdNotFoundException;
import com.harsh.airline_reservation_system_web.business_logic.misc.GetConnection;
import com.harsh.airline_reservation_system_web.business_logic.misc.GetCookies;
import com.harsh.airline_reservation_system_web.business_logic.operations.BookingOperationsImpl;
import com.harsh.airline_reservation_system_web.business_logic.operations.BookingOperationsInterface;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class CancelTrip extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BookingOperationsInterface bOps;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int tripID = Integer.parseInt(request.getParameter("tripID"));
		bOps = new BookingOperationsImpl();
		Map<String, String> cookieMap = GetCookies.getCookies(request, response);
		try {
			if(bOps.cancelReservation(tripID, cookieMap.get("email"), GetConnection.getConnection())) {
				request.setAttribute("deletedStatus", "true");
				request.getRequestDispatcher("./cancelTrip.jsp").forward(request, response);
			}
				
		} catch (TripIdNotFoundException e) {
			request.setAttribute("deletedStatus", "false");
			request.getRequestDispatcher("./cancelTrip.jsp").forward(request, response);
		}
	}

}
