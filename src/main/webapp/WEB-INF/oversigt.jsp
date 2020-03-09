<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dane
  Date: 04/03/2020
  Time: 09.03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Oversigt</title>
</head>
<body>

<c:forEach var="i" items="${sessionScope.users}">

    ${i}
    <br>


</c:forEach>

<br>
<br>

<form name="register" action="LogoutServlet" method="POST">
    <input type="submit" value="Logout">
</form>

</body>
</html>
