<%@ page import="java.util.List" %>
<%@ page import="ru.geekbrains.homework1.model.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <title>Product</title>
</head>

<body>
    <h2>Products:</h2>
    <ul>
        <% for(Product value: (List<Product>) ((Product)request.getAttribute("product")).getProducts()) { %>
            <li>Id: <%=value.getId()%>; Title: <%=value.getTitle()%>; Cost: <%=value.getCost()%></li>
        <% } %>
    </ul>
</body>

</html>