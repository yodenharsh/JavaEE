package com.harsh.airline_reservation_system_web.business_logic.misc;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GetCookies {
	public static Map<String, String> getCookies(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Cookie[] cookies = null;
		Map<String, String> cookieMap = new HashMap<>();

		cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			cookieMap.put(cookie.getName(), cookie.getValue());
		}
		return cookieMap;
	}
}
