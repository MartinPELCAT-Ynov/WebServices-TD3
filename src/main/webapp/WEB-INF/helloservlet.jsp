<%--
  Created by IntelliJ IDEA.
  User: martinpelcat
  Date: 05/11/2021
  Time: 12:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String userToGreet = (String) request.getAttribute("userToGreet");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>Hello <%= userToGreet %>
</p>
</body>
</html>
