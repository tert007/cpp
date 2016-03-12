<%--
  Created by IntelliJ IDEA.
  User: Alexander
  Date: 22.02.2016
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>UserTable</title>
</head>
<body>
    <table>
        <caption>Пользователи</caption>
        <tr>
            <th>id</th>
            <th>login</th>
            <th>email</th>
        </tr>

        <c:forEach var="user" items="${GET_USERS_COLLECTION}">
            <tr>
                <td>${user.getId()}</td>
                <td>${user.getLogin()}</td>
                <td>${user.getEmail()}</td>
            </tr>
        </c:forEach>

    </table>
</body>
</html>
