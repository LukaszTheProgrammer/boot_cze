<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Companies</title>
</head>
<body>

<form method="post" action="/companies">
    <label>NIP:</label>
    <input type="text" name="nip"/><br/>
    <label>Nazwa:</label>
    <input type="text" name="nazwa"/><br>
    <input type="submit" value="Wyszukaj"/>
</form>

<c:if test="${companies != null}">
    <c:forEach var="company" items="${companies}">
        Nazwa: ${company.nazwa}<br/>
        NIP: ${company.NIP}<br/>
        Regon: ${company.regon}<br/>
        Ulica: ${company.address.street}<br/>
        Numer: ${company.address.number}<br/>
        Miasto: ${company.address.city}<br/>
    </c:forEach>
</c:if>

</body>
</html>
