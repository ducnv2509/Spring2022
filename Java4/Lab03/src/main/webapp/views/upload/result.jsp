<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<h2>Hinh: ${image}</h2>
<img alt="OK" src="uploads/${image}" height="100">

<h2>Tai Lieu: ${document}</h2>

<a href="uploads/${document}">Tai Ve</a>
</body>
</html>