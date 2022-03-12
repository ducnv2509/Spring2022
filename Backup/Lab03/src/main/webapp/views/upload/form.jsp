<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<form action="/Lab03/UploadServlet" method="post"
      enctype="multipart/form-data">
    Hinh Anh: <input type="file" name="document"> Tai Lieu: <input
        type="file" name="image">
    <hr>
    <button>Update</button>
</form>

</body>
</html>