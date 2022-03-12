<%--
  Created by IntelliJ IDEA.
  User: ducit
  Date: 3/10/2022
  Time: 9:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h2>1. Iamge: ${img.name}</h2>
<img src="/Lab3_war/files/${img.name}" alt="">

<h2>2. Tài liệu: ${doc.name}</h2>
<a href="/Lab3_war/files/${doc.name}">Tải về</a>
</body>
</html>
