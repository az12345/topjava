<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>MealList</h3>
<table cellspacing="5" cellpadding="10" border="1">
    <thead>
    <tr>
        <td>Date&Time</td>
        <td>Description</td>
        <td>Calories</td>
    </tr>
    </thead>

    <c:forEach var="el" items="${list}">
        <c:if test="${el.exceed}">
            <tr style="color: red">
                <td><c:out value="${el.dateTime}"/></td>
                <td><c:out value="${el.description}"/></td>
                <td><c:out value="${el.calories}"/></td>
            </tr>
       </c:if>
        <c:if test="${!el.exceed}">
            <tr style="color: green">
                <td><c:out value="${el.dateTime}"/></td>
                <td><c:out value="${el.description}"/></td>
                <td><c:out value="${el.calories}"/></td>
            </tr>
        </c:if>
    </c:forEach>
</table>
</body>
</html>