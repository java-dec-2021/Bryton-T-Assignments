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
	<div class="row">
		<h1>Hey ${User.name}, check out this cool idea!</h1>
		<a href="/logout" class="btn">Logout</a>
	</div>
</header>
<main>
	<h3>${Idea.idea_name}</h3>
	<div class="row">
		<p>Created by: ${Idea.user.name}</p>
	</div>
	<h3>Users who liked ${Idea.idea_name}</h3>
	<table>
		<thead>
	        <tr>
	            <th>Name</th>
	        </tr>
		</thead>
		<tbody>
		<c:forEach items="${Idea.likedBy}" var="Like">
			<tr>
				<td>${Like.name}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<a href="/ideas/${Idea.id}/edit" class="btn">Edit</a>
	<a href="/ideas/${Idea.id}/delete" class="btn">Delete</a>
</main>
</body>
</html>