<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String user = request.getParameter("username");
    String pass = request.getParameter("password");
    if(user != null && pass != null ) {
        if (user.equals("admin") && pass.equals("password")) {
            response.sendRedirect("profile.jsp");
        } else {
            response.getWriter().println("Invalid credentials, try again.");
        }
    }
%>
<html>
<head>
    <title>Login</title>
</head>
<body>
<%@ include file="partials/navbar.jsp" %>
    <form action="/login.jsp" method="POST" >
        <label>Username
            <input id="username" name="username" type="text">
        </label>
        <br>
        <label>Password
            <input id="password" name="password" type="password">
        </label>
        <br>
        <input type="submit">
    </form>
</body>
</html>
