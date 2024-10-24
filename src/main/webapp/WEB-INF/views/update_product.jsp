<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Product</title>
</head>
<body>
<h2>Update Product</h2>
<form action="/saveProduct" method="post">
<input type="hidden" name="id" value="${product.id}">
Name: <input type="text" name="name" value="${product.name}"><br>
Price: <input type="text" name="price" value="${product.price}"><br><br>
<input type="submit" value="Update">
</form>
</body>
</html>
