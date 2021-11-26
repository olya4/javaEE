<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 27.11.2021
  Time: 0:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products</title>
</head>
<body>
<h1>Products List</h1>
<ul>
    <jsp:useBean id="products" scope="request" type="java.util.List"/>
    <c:forEach var="product" items="${products}">
        <c:url var="viewUrl" value="/product/${product.id}">
        </c:url>
        <li>
            Product id: ${product.id}
            <br>
            Product title: ${product.title}
            <br>
            Product cost: ${product.cost}
            <a href="${viewUrl}">View</a>
            <br>
        </li>
    </c:forEach>
</ul>
<c:url var="createUrl" value="/product/create">
</c:url>
<a href="${createUrl}">Create</a>
</body>
</html>
