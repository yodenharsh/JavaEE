<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Change Password</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="container-fluid text-center">
		<div class="card mx-auto" style="width: 35rem; margin-top: 20px">
			<div class="card-body">
				<h5 class="card-title">Change Password</h5>
				<form action="change-password" method="POST">
					<div class="form-group">
						<label for="new-password">New Password:</label> <input
							name="new-password" type="password" class="form-control"
							id="new-password" placeholder="Enter new password">
					</div>
					<button value="Submit" type="submit" class="btn btn-primary mt-5">Change password</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>