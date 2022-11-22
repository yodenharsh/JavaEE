<html>
<title>Login page</title>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css"
	href="./styles/index.css">
<body>
	<%@ include file="header.jsp"%>
	<div class="container-fluid text-center">
		<div class="card mx-auto" style="width: 35rem; margin-top: 20px">
			<div class="card-body">
				<h5 class="card-title">Login</h5>
				<form action="confirm-login" method="POST">
					<div class="form-group">
						<label for="email">Email address </label> <input name="email"
							type="email" class="form-control" id="InputEmail"
							aria-describedby="emailHelp" placeholder="Enter email">
						<p id="wrong-email" class="invalid-feedback">Email invalid</p>
						<small id="emailHelp" class="form-text text-muted">We'll
							never share your email with anyone else.</small>
					</div>
					<div class="form-group">
						<label for="password">Password</label> <input
							name="password" type="password" class="form-control"
							id="InputPassword" placeholder="Password">
					</div>
					<button value="Submit" type="submit" class="btn btn-primary mt-5">Login</button>
				</form>
				<a href="signup.jsp" class="card-link link-danger">Don't have an
					account? Sign up</a>
			</div>
		</div>
	</div>

</body>
</html>
