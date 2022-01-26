<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Product</title>
</head>
<body>
	<h1>New Product</h1>
	<form:form action="/products/new" method="post" modelAttribute="newProduct">
	    <p>
	        <form:label path="name">Name</form:label>
	        <form:input path="name"/>
	        <form:errors path="name" class="text-danger"/>
	    </p>
	    <p>
	        <form:label path="description">Description</form:label>
	        <form:errors path="description"/>
	        <form:input path="description"/>
	    </p>
	    <p>
	        <form:label path="price">Price</form:label>
	        <form:errors path="price"/>
	        <form:input path="price"/>
	    </p>
	    <input type="submit" value="Submit"/>
	</form:form>  

</body>
</html>