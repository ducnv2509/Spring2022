<%--
  Created by IntelliJ IDEA.
  User: ducit
  Date: 3/9/2022
  Time: 1:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/View2_war_exploded/LoginServlet">
    <div>
        <label for="">Email</label>
        <input type="email" name="email">
    </div>

    <div>
        <label for="">Password</label>
        <input type="password" name="password">
    </div>

    <button>
        Đăng nhập
    </button>

    <ul>
        <li>email: ${email}</li>
        <li>password: ${password}</li>
    </ul>
</form>
</body>
</html>
