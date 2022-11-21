package com.harsh.airline_reservation_system_web.ui;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Map;

import com.harsh.airline_reservation_system_web.business_logic.custom_exceptions.NoTripsFoundException;
import com.harsh.airline_reservation_system_web.business_logic.misc.GetConnection;
import com.harsh.airline_reservation_system_web.business_logic.misc.GetCookies;
import com.harsh.airline_reservation_system_web.business_logic.operations.BookingOperationsImpl;
import com.harsh.airline_reservation_system_web.business_logic.operations.BookingOperationsInterface;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class ViewTrips extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BookingOperationsInterface bOps;
	
    public ViewTrips() {
    }

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection conn = GetConnection.getConnection();
		bOps = new BookingOperationsImpl();
		Map<String, String> cookieMap = GetCookies.getCookies(req, resp);
		String email = cookieMap.get("email");
		try {
			ResultSet rs = bOps.getReservations(email, conn);
			req.setAttribute("isEmpty", "false");
			req.setAttribute("flightTable", rs);
			req.getRequestDispatcher("./viewTrips.jsp").forward(req, resp);
		} catch(NoTripsFoundException e) {
			req.setAttribute("isEmpty", "true");
			req.getRequestDispatcher("./viewTrips.jsp").forward(req, resp);
			return;
	}

	}
}
