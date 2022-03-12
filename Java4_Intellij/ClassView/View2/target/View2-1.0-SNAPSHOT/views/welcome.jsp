<%--
  Created by IntelliJ IDEA.
  User: ducit
  Date: 3/9/2022
  Time: 12:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/View2_war_exploded/Welcome" method="post">
    <label for="">Ho Ten</label>
    <input type="text" name="fullname">
    <button> Gui</button>
</form>
<h1>Hello Word + ${fullname}</h1>

</body>
</html>
