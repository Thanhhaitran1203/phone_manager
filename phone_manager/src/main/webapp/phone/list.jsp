<%--
  Created by IntelliJ IDEA.
  User: hai
  Date: 2/4/2024
  Time: 10:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Phone Manager</title>
</head>
<body>
<h1>Phone List</h1>
<a href="/?action=create">Create new phone</a>
<table border="1px">
    <tr>
        <td>Name</td>
        <td>Price</td>
        <td>Phone Category</td>
        <td>Decriptiom</td>
    </tr>
    <c:forEach items='${requestScope["phoneList"]}' var="phone">
        <tr>
            <td>${phone.getName()}</td>
            <td>${phone.getPrice()}</td>
            <td>${phone.getPhoneCategory()}</td>
            <td>${phone.getDescription()}</td>
        </tr>
    </c:forEach>
    <tr>

    </tr>
</table>
</body>
</html>
