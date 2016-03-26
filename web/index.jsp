<%--
  Created by IntelliJ IDEA.
  User: Alexander
  Date: 16.02.2016
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Cinema</title>
  </head>
  <body>
  <form action="/testServlet" method="Get">
    <input type="submit" name="command" value="get_users_collection">
  </form>
  <form action="/testServlet" method="Get" name="regestration">
    <input type="text" name="login">
    <input type="password" name="password">
    <input type="submit" name="command" value="reg_user">
  </form>
  </body>
</html>
