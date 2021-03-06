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
	<a href="/">Dashboard</a>
	<p>Name: <c:out value="${language.name}"></c:out></p>
	<p>Creator: <c:out value="${language.creator}"></c:out></p>
	<p>Version: <c:out value="${language.version}"></c:out></p>
	<a href="/languages/${language.id}/edit">Edit</a>
	<a href="/delete/${language.id}">Delete</a>
</body>
</html>