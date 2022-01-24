<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Product</title>
</head>
<body>
	<h1>New Product</h1>
	<form action="/products/new" method="post">
		<label for="name">Name</label>
		<input type="text" id="name"><br>
		<label for="description">Description</label>
		<input type="textarea" rows="3" cols="5" id="description"><br>
		<label for="price">Price</label>
		<input type="text" id="price"><br>
		<input type="submit" value="Create">
	</form>
</body>
</html>