<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="com.springboot.Product" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product List</title>
</head>
<body>
<h2>Product List</h2>
<table border="1">
<tr>
<th>ID</th>
<th>Name</th>
<th>Price</th>
<th colspan="2">Actions</th>
</tr>
<% List<Product> products = (List<Product>)request.getAttribute("listProducts");
for(Product product : products)
{
    %><tr>
    <td><%= product.getId() %></td>
    <td><%= product.getName() %></td>
    <td><%= product.getPrice() %></td>
    <td><a href="/updateProduct/<%= product.getId() %>">Edit</a></td>
    <td><a href="/deleteProduct/<%= product.getId() %>">Delete</a></td>
    </tr>
<% } %>
</table>

<!-- Pagination controls -->
<nav aria-label="Page navigation">
    <ul class="pagination">
        <c:forEach begin="0" end="${totalPages - 1}" var="i">
            <li class="page-item ${i == currentPage ? 'active' : ''}">
                <a class="page-link" href="?page=${i}&size=5">${i + 1}</a>
            </li>
        </c:forEach>
    </ul>
</nav>

</body>
</html>
