<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Hello Human</title>
</head>
<body>
	<h1>Hello <c:out value="${name} "/><c:out value="${lastName}"/></h1>
	<c:forEach var="i" begin="2" end="${times}">
		<h1>Hello <c:out value="${name} "/><c:out value="${lastName}"/></h1>
	</c:forEach>
</body>
</html>