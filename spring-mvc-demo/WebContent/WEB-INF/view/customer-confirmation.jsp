<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Confirmation Page</title>
</head>
<body>

<p>The customer's name is: ${customer.firstName} ${customer.lastName}</p>
<p>Course code: ${customer.courseCode} </p>
</body>
</html>