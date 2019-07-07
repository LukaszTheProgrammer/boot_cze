<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create User</title>
</head>
<br>
<h1>Create User</h1>
<c:if test="${errorMessage != null}">
    <div style="background-color: red;">${errorMessage}</div>
</c:if>
<form method="post" action="/users">
    <label>Email:</label><input type="email" name="email"/><br/>
    <label>Password:</label><input type="password" name="password"/><br/>
    <label>Date of Birth:</label><input type="date" name="dateOfBirth"/><br/>
    <input type="submit" value="Dodaj"/>
</form>


</body>
</html>
