<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add New Product</title>
</head>
<body>
<h2>Add New Product</h2>
<form action="/saveProduct" method="post">
Name: <input type="text" name="name"><br>
Price: <input type="text" name="price"><br><br>
<input type="submit" value="Submit">
</form>
</body>
</html>
