<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Flight booking</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
	
</script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js">
	
</script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js">
	
</script>

<!-- CDN link used below is compatible with this example -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/css/bootstrap-select.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/js/bootstrap-select.min.js">
	
</script>
</head>
<body>
	<%@ include file="./header.jsp"%>
	<div class="container-fluid mt-5 ml-2">
		<form method="GET" action="new-trips">
			<div>
				<label for="to" class="h3">To: </label> <select name="to"
					class="selectpicker" data-style="btn-success">
					<option value="Mumbai">Mumbai</option>
					<option value="Dubai">Dubai</option>
					<option value="New York">New York</option>
					<option value="London">London</option>
					<option value="Seoul">Seoul</option>
				</select>
			</div>
			<div class="mt-2">
				<label for="from" class="h3">From </label> <select name="from"
					class="selectpicker" data-style="btn-warning">
					<option value="New York">New York</option>
					<option value="Mumbai">Mumbai</option>
					<option value="London">London</option>
					<option value="Seoul">Seoul</option>
				</select>
			</div>
			<div class="mt-2">
				<label for="people" class="h3">No. of people: </label>
				<input type="number" name="people" title="people"/>
			</div>
			<div class="mt-2 mb-2">
				<label for="date" class="h3">Date: </label>
				<input type="date" name="date" title="date"/>
			</div>
			<button type="submit" class="btn btn-light">Book flight</button>
		</form>
	</div>
</body>
</html>