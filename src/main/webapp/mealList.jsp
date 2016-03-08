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

    <c:forEach var="el" items="${list}">
        <c:set var="color" value="green"/>
        <c:if test="${el.exceed}">
            <c:set var="color" value="red"/>
        </c:if>

        <fmt:formatDate value="${parsedDate}" var="newParsedDate" type="both" />
        <tr style="color: ${color}">
            <td><javatime:format value="${el.dateTime}" style="MS" pattern="yyyy-M-dd H:mm"/></td>
            <td><c:out value="${el.description}"/></td>
            <td><c:out value="${el.calories}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>