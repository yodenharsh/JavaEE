<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer registration form</title>
<style>
.error {
	color: red;
}
</style>
</head>
<body>

	<form:form action="processForm" modelAttribute="customer">

		<p>* is required</p>

		<br>
		<br>
	
	Last Name* : <form:input path="lastName" />
		<form:errors path="lastName" cssClass="error"></form:errors>

		<br>
		<br> 
	First Name: <form:input path="firstName" />
		<br>
		<br>

	Course code: <form:input path="courseCode" />
	<form:errors path="courseCode" cssClass="error"/>
	<br><br>

		<input type="submit" value="submit" />
	</form:form>
</body>
</html>