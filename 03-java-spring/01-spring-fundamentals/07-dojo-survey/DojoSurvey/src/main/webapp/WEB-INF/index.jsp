<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dojo Survey Index</title>
</head>
<body> 
	<h3>Welcome to the Survey!</h3>
	<form action="/welcome" method="POST">
		<p> Your Name: <input type="text" name="name"></p>
		<p> Dojo Location:
			<select name="location">
				<option value="SanJose">San Jose</option>
				<option value="Seattle">Seattle</option>
				<option value="NewYork">New York</option>
				<option value="Tokyo">Tokyo</option>
				<option value="Burbank">Burbank</option>
			</select>
		</p>
		<p> Favorite Language:
			<select name="program">
				<option value="Python">Python</option>
				<option value="Java">Java</option>
				<option value="HTML">HTML</option>
				<option value="C++">C++</option>
				<option value="MERN">MERN</option>
			</select>
		</p>
		<p>Comment (optional):</p>
		<p>
			<textarea rows="5" cols="30" name="comment"></textarea>
		</p>
		<p><button>Submit</button></p>
	</form>
</body>
</html>