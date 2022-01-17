<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Ninja</title>
</head>
<body>
	<h1>New Ninja Page</h1>
	<form action="/create/ninja" method="post">
		<div>
			<label for="Dojo">Dojo:</label>
			<select>
	           <c:forEach items="${dojos}" var="dojo">
	               <option value="<c:out value="${dojo.id}"/>"><c:out value="${dojo.name}"/></option>
	           </c:forEach>
			</select>
		</div>
		<div>
			<label for="first_name">First Name:</label>
			<input type="text" name="first_name">
		</div>
		<div>
			<label for="last_name">Last Name:</label>
			<input type="text" value="last_name">
		</div>
		<div>
			<label for="age">Age:</label>
			<input type="text" value="age">
		</div>
		<div>
			<input type="submit">
		</div>
	</form>
</body>
</html>