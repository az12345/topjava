<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>MealList</h3>
<table>
    <thead>
    <tr>
        <td>Id</td>
        <td>Date&Time</td>
        <td>Description</td>
        <td>Calories</td>
    </tr>
    </thead>

    <c:forEach var="el" items="${list}">
    <tr>
        <td><c:out value="${el.}"></td>
    </tr>
    </c:forEach>
</body>
</html>

