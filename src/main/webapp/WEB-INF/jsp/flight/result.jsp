<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Flights result</title>
</head>
<body>
<c:forEach var="flight" items="${flights}">
    <c:out value="${flight.from}"/> ->
    <c:forEach var="connection" items="${flight.connections}">
        <c:out value="${connection}"/> ->
    </c:forEach>
    <c:out value="${flight.to}"/>
</c:forEach>
</body>
</html>
