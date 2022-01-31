<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
    crossorigin="anonymous"/>
<title>Ideas</title>
</head>
<body>
<header>
	<h1>Hi <c:out value="${User.name}"/>, let's brainstorm a new idea!</h1>
	<a href="/logout" class="btn">Logout</a>
</header>
<main>
	<h3>What are you thinking?</h3>
	<form:form method="POST" action="/ideas/new" modelAttribute="idea">
		<p class="form-group">
			<form:label path="idea_name">Name:</form:label>
			<form:input class="form-control" path="idea_name"/>
			<form:errors class="text-danger" path="idea_name"/>
		</p>
		<form:input type="hidden" value="${User.id}" path="user"/>
		<input type="submit" value="Create"/>
	</form:form>
</main>
</body>
</html>