<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="/assignment/styles/index.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<title>Signup</title>
</head>
<body>
<%@ include file="header.jsp" %>
 <div class="container-fluid text-center">
        <div class="card mx-auto" style="width: 35rem;margin-top:20px">
            <div class="card-body">
                <h5 class="card-title">Signup</h5>
                <form action="signup" method="POST">
                    <div class="form-group">
                        <label for="email">Email address</label>
                        <input name="email" type="email" class="form-control" id="InputEmail" aria-describedby="emailHelp" placeholder="Enter email">
                        <p id="wrong-email" class="invalid-feedback">Invalid email</p>
                        <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Password</label>
                        <input name="password" type="password" class="form-control" id="InputPassword" placeholder="Password">
                    </div>
                    <?php require_once('./layout/upload_png.php') ?>
                    <button value="Submit" type="submit" class="btn btn-primary mt-5">Sign up</button>
                </form>
                <a href="./index.jsp" class="card-link link-danger">Login instead</a>
            </div>
        </div>
    </div>
</body>
</html>