<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <li>
            Product id: ${product.id}
            <br>
            Product title: ${product.title}
            <br>
            Product cost: ${product.cost}
            <br>
        </li>
    </c:forEach>
</ul>
</body>
</html>
