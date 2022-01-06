<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="uft-8">
    <title>Insert title here</title>
</head>
<body>
<form action="TamGiacServlet" method="post">
    <input name="a" placeholder="Canh a ?"> <br> <input
        name="b" placeholder="Canh b ?"> <br> <input name="c"
                                                     placeholder="Canh c ?">
    <button formaction="dien-tich">Tinh Dien Tich</button>
    <br>
    <button formaction="chu-vi">Tinh Chu Vi</button>
</form>
<hr>

<h2>${message}</h2>

</body>
</html>