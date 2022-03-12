<%--
  Created by IntelliJ IDEA.
  User: ducit
  Date: 3/9/2022
  Time: 12:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<ul>
    <li>Tên đăng nhập: <b>${param.username}</b></li>
    <li>Mật khẩu: <b>${param.password}</b></li>
    <li>Giới tính: <b>${param.gender}</b></li>
    <li>Tình trạng hôn nhân: <b>${param.married}</b></li>
    <li>Quốc tịch: <b>${param.country}</b></li>
    <li>Ghi chú: <b>${param.notes}</b></li>
</ul>
</body>
</html>
