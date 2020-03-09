<%-- 
    Document   : employeepage.jsp
    Created on : Aug 24, 2017, 6:31:57 AM
    Author     : kasper
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee home page</title>
    </head>
    <body>


        <h1>Hello ${sessionScope.email} </h1>

        You are now logged in as a EMPLOYEE of our wonderful site.
        <br>
        <form name="login" action="FrontController" method="POST">
            <input type="hidden" name="taget" value="oversigt">
            <input type="submit" value="Oversigt">
        </form>
        <br>

        <h3>Register User</h3>

        <form name="register" action="FrontController" method="POST">
            <input type="hidden" name="taget" value="registerEmployee">
            Email:<br>
            <input type="text" name="email" value="someone@nowhere.com">
            <br>
            Password:<br>
            <input type="password" name="password1" value="sesam">
            <br>
            Retype Password:<br>
            <input type="password" name="password2" value="sesam">
            <br>
            <input type="submit" value="Submit">
        </form>
        <br>
        <h3>Delete User</h3>

        <form name="register" action="FrontController" method="POST">
            <input type="hidden" name="taget" value="deleteUser">
            Email:<br>
            <input type="text" name="email" value="someone@nowwhere.com">
            <input type="submit" value="Submit">
        </form>
        <br>

        <h3>Change Password</h3>

        <form name="register" action="FrontController" method="POST">
            <input type="hidden" name="taget" value="changePassword">
            Email:<br>
            <input type="text" name="email" value="someone@nowhere.com">
            Password<br>
            <input type="text" name="password" value="sesam">
            <input type="submit" value="Submit">
        </form>
        <br>
        <br>

        <form name="register" action="LogoutServlet" method="POST">
            <input type="submit" value="Logout">
        </form>

    </body>
</html>
