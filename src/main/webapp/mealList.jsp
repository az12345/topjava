<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://sargue.net/jsptags/time" prefix="javatime" %>

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

    <c:forEach var="meal" items="${list}">
        <c:set var="color" value="green"/>
        <c:if test="${meal.exceed}">
            <c:set var="color" value="red"/>
        </c:if>
        <tr style="color: ${color}">
            <td><javatime:format value="${meal.dateTime}" style="MS" pattern="dd-M-yyyy H:mm"/></td>
            <td><c:out value="${meal.description}"/></td>
            <td><c:out value="${meal.calories}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>