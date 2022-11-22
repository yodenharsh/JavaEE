<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cancel Flight</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="container-fluid text-center">
		<div class="card mx-auto" style="width: 35rem; margin-top: 20px">
			<div class="card-body">
				<h5 class="card-title">Cancel Flight</h5>
				<form action="cancel-trip" method="GET">
					<div class="form-group">
						<label for="tripID">Enter Flight ID:</label> <input name="tripID"
							type="text" class="form-control" id="tripID"
							placeholder="Enter Flight ID">
					</div>
					<button value="Submit" type="submit" class="btn btn-danger mt-3">Cancel
						Trip</button>
				</form>
				<p class="mt-3">Don't know Flight ID? <a href="view-trips">View here</a></p>
			</div>
		</div>
		<% 
		String cancellationSuccess = "";
		try{
		cancellationSuccess = (String)(request.getAttribute("deletedStatus"));
		%>
		<div class="mt-2">
		<% if(cancellationSuccess.equals("true")) { %>
			<h4>Flight has been cancelled</h4>
		<% }
		 else if(cancellationSuccess.equals("false")){ %>
			<h4>Flight ID does not match any booked flights</h4>
			<% }} catch(Exception e){} %>
		</div>
	</div>
</body>
</html>