<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Dojo</title>
</head>
<body>
	<h1>New Dojo Page</h1>
	<form action="/create/dojo" method="POST">
		<p>
			<label for="name">Name:</label>
			<errors path="DojoName"/>
			<input type="text" id="name" name="name"/>
			<c:if test="${!error.equals('')}">
				<c:out value = "${error}"/>
			</c:if>
		</p>
		<button type="submit"> Create </button>
	</form>
	<h1>All Dojos</h1>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${dojos}" var="dojo">
			<tr>
				<td><a href="/dojo/${dojo.id}">${dojo.name}</a></td>
				<td>
					<a href="/dojo/${dojo.id}/edit">edit</a>
					<a href="/delete/${dojo.id}">delete</a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>