<%@ page import="java.util.List" %>
<%
    List<String> notes = (List<String>) request.getAttribute("notes");
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Notes</h1>
<ul>
    <% for (String note : notes) { %>
    <li><%= note %>
    </li>
    <% } %>
</ul>


<form method="get" action="/note/add">
    <input type="text" name="note" placeholder="note" autofocus/>
    <input type="submit" value="Add"/>
</form>
</body>
</html>
