<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.io.PrintWriter" %>
<%--
  Created by IntelliJ IDEA.
  User: natdog37mac
  Date: 2019-02-06
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../partials/head.jsp">
        <jsp:param name="title" value="Ads" />
    </jsp:include>
    <style>
        .indent{
            margin-left: 1em;
        }
    </style>
</head>
<body >
<jsp:include page="../partials/navbar.jsp" />
<div class="container">

    <h1>List of ads</h1>


    <c:forEach var="ad" items="${ads}">
    <div class="indent" >
        <h4>${ad.getTitle()}</h4>
        <p>${ad.getDescription()}</p>
    </div>
</c:forEach>

</div>
</body>
</html>
