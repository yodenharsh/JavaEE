<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Age calculator</title>
<style>
<%@
include file="/WEB-INF/styles/age-calculator.css"%>
</style>
<body style="background: #060c21;">
<header class="main-header dark-theme">
<div class="title-container">
	<p class="title">Age Calculator - made by Harsh Morayya</p>
	</div>
</header>
	<div class="form">
	<h2>Enter Your Details</h2>
	<form:form action="processForm" modelAttribute="userDetails">
	<div class="input">
	<div class="inputBox">
	<label>Enter name: </label> <form:input path="name" cssClass="form-control" />
	</div>
		<form:errors path="name" cssClass="error"><p class="error">Name cannot be empty</p></form:errors>
	<div class="inputBox">
		
	<label>Enter DOB (DD/MM/YYYY): </label> <form:input path="dob" cssClass="form-control" />
		<form:errors path="dob" cssClass="error" ><p class="error">Date not in correct format</p></form:errors>
	</div>
	<div class="inputBox">	
		<input type="submit" value="Submit Details" />
	</div>
	<div class="request-count">
	<p>We have processed <b>${requestCount}</b> request(s) so far</p>
	</div>
	</div>
	</form:form>
</div>
</body>
</html>