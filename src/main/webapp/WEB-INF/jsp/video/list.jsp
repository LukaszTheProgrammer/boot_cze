<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Video list</title>
    <style>
        th, td {
            border: 1px solid black;
            padding: 10px;
        }

        table {
            border-collapse: collapse;
        }

        .videoList th {
            background-color: cadetblue;
            color: #fff;
        }

        .mainContainer {
            width: 80%;
            margin: 0 auto;
        }
    </style>
</head>
<body>
<a href="/video/add">Add Video</a>
<div class="mainContainer">
    <c:if test="${videos.size() > 0}">
        <table class="videoList">
            <tr>
                <th>
                    Title
                </th>
                <th>
                    Actions
                </th>
            </tr>
            <c:forEach items="${videos}" var="video">
                <tr>
                    <td>${video.title}</td>
                    <td>
                        <a href="/video/${video.id}">View</a>
                        <a href="/video/${video.id}/edit">Edit</a>
                        <a href="/video/${video.id}/delete">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>
</body>
</html>
