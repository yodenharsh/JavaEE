<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Your Age</title>
<style>
<%@
include file="/WEB-INF/styles/show-age.css"%>
</style>
</head>
<body style="background: #060c21;">
<header class="main-header dark-theme">
<div class="title-container">
	<a class="title">Age Calculator - made by Harsh Morayya</a>
	</div>
</header>
<div class="main-card">
<h1>${userDetails.name}, your age is ${age}</h1>
<hr>
</div>
</body>
</html>