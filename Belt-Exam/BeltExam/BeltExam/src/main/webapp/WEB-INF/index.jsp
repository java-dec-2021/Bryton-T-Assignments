<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous"/>
<title>Ideas</title>
</head>
<body>
<header>
	<h1>Welcome!</h1>
	<a href="/logout" class="btn">Logout</a>
</header>
<main>
	<div class="row">
		<div class="col">
			<h1>Register</h1>
			<form:form method="POST" action="/register" modelAttribute="user">
				<div class="form-group">
					<form:label path="name">Name:</form:label>
					<form:input class="form-control" path="name"/>
					<form:errors class="text-danger" path="name"/>
				</div>
				<div class="form-group">
					<form:label path="email">Email:</form:label>
					<form:input class="form-control" path="email"/>
					<form:errors class="text-danger" path="email"/>
				</div>
				<div class="form-group">
					<form:label path="password">Password:</form:label>
					<form:password class="form-control" path="password"/>
					<form:errors class="text-danger" path="password"/>
				</div>
				<div class="form-group">
					<form:label path="passwordConfirmation">Confirm Password:</form:label>
					<form:password class="form-control" path="passwordConfirmation"/>
					<form:errors class="text-danger" path="passwordConfirmation"/>
				</div>
				<input type="submit" value="Register"/>
			</form:form>
		</div>
		<div class="col">
			<h1>Login</h1>
			<form method="POST" action="/login">
				<div class="form-group">
					<label for="email">Email:</label>
					<input class="form-control" type="text" id="email" name="email"/>
				</div>
				<div class="form-group">
					<label for="password">Password:</label>
					<input class="form-control" type="password" id="password" name="password"/>
				</div>
				<input type="submit" value="Login"/>
			</form>
		</div>
	</div>
</main>
</body>
</html>