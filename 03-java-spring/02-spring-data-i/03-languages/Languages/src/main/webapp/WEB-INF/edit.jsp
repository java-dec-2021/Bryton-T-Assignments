<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><c:out value="${language.name}"><</c:out></title>
</head>
<body>
	<p>
		<a href="/delete/${language.id}">Delete</a>
		<a href="/">Dashboard</a>
	</p>
	<form action="/languages" method = "POST">
		<p>
			<label for="name">Name</label>
			<input type="text" id="name" name="name">
		</p>
		<p>
			<label for="creator">Creator</label>
			<input type="text" id="creator" name="creator">
		</p>
		<p>
			<label for="version">Version</label>
			<input type="text" id="version" name="version">
		</p>
		<input type="submit" value="Submit">
	</form>
</body>
</html>