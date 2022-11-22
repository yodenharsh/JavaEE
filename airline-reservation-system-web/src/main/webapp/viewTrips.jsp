<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.ResultSet" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Viewing trips</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
</head>
<link rel="stylesheet" type="text/css" href="./styles/viewTrips.css">
<body>
<%@ include file="header.jsp" %>
<% if(Boolean.parseBoolean(request.getAttribute("isEmpty").toString())){ %>
<div class="container-fluid mt-5 text-center">
<h2>No flights have been booked yet!</h2>
</div>
<% } else {
	ResultSet flightTable = (ResultSet) request.getAttribute("flightTable");%>
<div class="container-fluid mt-5">
	<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">Flight ID</th>
      <th scope="col">To</th>
      <th scope="col">From</th>
      <th scope="col">People</th>
      <th scope="col">Date (YYYY-MM-DD)</th>
    </tr>
  </thead>
  <tbody>
<% do{
	String flightId = String.valueOf(flightTable.getInt("tripId"));
	String to = flightTable.getString("toWhere");
	String from = flightTable.getString("fromWhere");
	String people = String.valueOf(flightTable.getInt("people"));
	String date = String.valueOf(flightTable.getDate("date"));%>
	<tr>
	<td><%= flightId %></td>
	<td><%= to %></td>
	<td><%= from %></td>
	<td><%= people %></td>
	<td><%= date %></td>
	</tr>
<% }while(flightTable.next()); %>
  </tbody>
</table>
</div>
<div class="mt-5 text-center link-container">
	<a href="./cancelTrip.jsp">Cancel a flight? </a>
</div>
<% } %>
</body>
</html>