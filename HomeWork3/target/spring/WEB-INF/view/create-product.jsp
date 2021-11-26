<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 27.11.2021
  Time: 0:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
</head>
<body>
<%--@elvariable id="product" type="ru.geekbrains.entity.Product"--%>
<form:form action="create" modelAttribute="product">
    <form:hidden path="id" value="${product.id}"/>
    Title: <form:textarea path="title"/>
    <br>
    Cost: <form:textarea path="cost"/>
    <br>
    <input type="submit" value="Submit">
</form:form>
</body>
</html>