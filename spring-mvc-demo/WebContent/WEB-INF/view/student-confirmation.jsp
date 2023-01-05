<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student confirmation</title>
</head>
<body>
<p>The student is confirmed: ${student.firstName} ${student.lastName}</p>
<p>Student is from: ${student.country}</p>
<p>Language: ${student.lang}</p>
<p>OS: 
<ul>
	<c:forEach var="temp" items="${student.OS}">
	<li>${temp}</li>
	</c:forEach>
</ul>
</body>
</html>