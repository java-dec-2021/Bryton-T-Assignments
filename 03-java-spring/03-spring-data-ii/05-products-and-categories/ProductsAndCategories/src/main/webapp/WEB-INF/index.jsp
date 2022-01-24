<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
    <%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
</head>
<body>
	<div class="container">
		<h1>All Products</h1>
		    <a href="/products/new">New Product</a>
		    <a href="/categories/new">New Category</a>
		<table>
		    <thead>
		        <tr>
		            <th>Product</th>
		            <th>Category</th>
		            <th>Action</th>
		        </tr>
		    </thead>
		    <tbody>
		        <c:forEach items="${Products}" var="Product">
		        <tr>
		            <td><c:out value="${Product.name}"/></td>
		             <td>
		             <c:forEach items="${Product.categories}" var="category">
						<p>- ${category.name}</p>
					</c:forEach>
		             <c:out value="${Category.name}"/>
		             
		             </td>
		            <td>
		               <form action="/delete/${User.id}" method="post">
							    <input type="hidden" name="_method" value="delete">
							    <input type="submit" value="Delete">
						</form>
						</td>
				</tr>
		        </c:forEach>
		    </tbody>
		</table>
	</div>
</body>
</html>