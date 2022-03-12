<%--
  Created by IntelliJ IDEA.
  User: ducit
  Date: 3/9/2022
  Time: 8:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/Lab02_war/tam-giac" method="post">
    <input type="text" name="a" placeholder="Cạnh a ?"> <br>
    <input type="text" name="b" placeholder="Cạnh b ?"> <br>
    <input type="text" name="c" placeholder="Cạnh c ?"> <br>
    <button formaction="/Lab02_war/dien-tich">
        Tính Diện Tích
    </button>
    <br>
    <button formaction="/Lab02_war/chu-vi">
        Tính Chu Vi
    </button>
</form>
<hr>
<h3>${message}</h3>

</body>
</html>
