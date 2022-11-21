<%@page import="jakarta.servlet.http.Cookie"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Cookie[] cookies = request.getCookies();
boolean isAuth = false;
if (cookies != null) {
	for (Cookie cookie : cookies) {
		if (cookie.getValue().equals("true") && cookie.getName().equals("isAuth"))
	isAuth = true;
	}
}
%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="./header.css">
</head>
<body>

</body>

<div class="container-fluid header">
	<header>
		<div style="display: inline-block">
			<h1>Airline reservation system</h1>
		</div>
		<nav class="main-nav mb-3">
			<ul class="main-nav__items">
				<%
				if (!isAuth) {
				%>
				<li class="main-nav__item"><a href="./index.jsp"><button
							type="button" class="btn btn-primary">Login</button></a></li>
				<%
				}
				%>
				<%
				if (isAuth) {
				%>
				<li class="main-nav__item"><a href="./changePassword.jsp"><button
							type="button" class="btn btn-primary">Change password</button></a></li>
				<li class="main-nav__item"><a href="./newTrips.jsp"><button
							type="button" class="btn btn-primary">Book a flight</button></a></li>
				<li class="main-nav__item"><a href="view-trips"><button
							type="button" class="btn btn-primary">View booked
							flights</button></a></li>
				<li class="main-nav__item"><a href="logout"><button
							type="button" class="btn btn-danger">Logout</button></a></li>
				<%
				}
				%>
			</ul>
		</nav>
	</header>
</div>

</html>