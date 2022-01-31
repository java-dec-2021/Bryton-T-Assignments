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
<title>Insert title here</title>
</head>
<body>
<header>
	<h1>Welcome, <c:out value="${User.name}"/>!</h1>
	<a href="/logout" class="btn">Logout</a>
</header>
	<h3>Ideas</h3>
	<table>
	    <thead>
	        <tr>
	            <th>Idea</th>
	            <th>Created By</th>
	            <th>Likes</th>
	            <th>Action</th>
	        </tr>
		</thead>
	    <tbody>
	        <c:forEach items="${Ideas}" var="Idea">
	        <tr>
	        	<td>
	        		<a href="/ideas/${Idea.id}">${Idea.idea_name}</a>
	        	</td>
	            <td>
					<p>${Idea.user.name}</p>
	            </td>
	          	<td>
					<p><c:out value="${Idea.likedBy.size()}"/></p>
	            </td>
	            <td>
	            	<c:choose>
		            	<c:when test="${Idea.likedBy.contains(user)}">
		            		<a href="/ideas/${Idea.id}/unlike">Unlike</a>
		            	</c:when>
		            	<c:otherwise>
			            	<a href="/ideas/${Idea.id}/like">Like</a>
		            	</c:otherwise>
	            	</c:choose>
				</td>
			</tr>
	        </c:forEach>
	    </tbody>
	</table>
	<a href="/ideas/new" class="btn">Create an idea</a>
</body>
</html>