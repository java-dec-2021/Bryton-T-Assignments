<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container col-4">
		<h1 class="my-3">${category.name}</h1>
		<div>
			<h3 class="my-3">Products:</h3>
			<c:forEach items="${category.products}" var="product">
				<p>- ${product.name}</p>
			</c:forEach>
		</div>		
		<form method="POST" action="/categories/${category.id}">
			<label>Select a product:</label>
			<select name="product">
				<c:forEach items="${products}" var="product">
					<option value="${product.id}">${product.name}</option>
				</c:forEach>
			</select>
			<button class="btn btn-warning">Add</button>
		</form>
		
		<p class="mt-5">
			<a href="/products/new">Create Product</a>
		</p> 
		<a href="/categories/new">Create Category</a>
	</div>
</body>
</html>