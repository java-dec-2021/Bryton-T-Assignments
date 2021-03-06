<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Languages</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<td>Name</td>
				<td>Creator</td>
				<td>Version</td>
				<td>action</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items= "${languages}" var= "language">
			<tr>
				<td><a href="/languages/${language.id}"><c:out value="${language.name}"></c:out></a></td>
				<td><c:out value="${language.creator}"></c:out></td>
				<td><c:out value="${language.version}"></c:out></td>
				<td>
					<a href="/delete/${language.id}">delete</a>
					<a href="/languages/${language.id}/edit">edit</a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
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