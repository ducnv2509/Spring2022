<%--
  Created by IntelliJ IDEA.
  User: ducit
  Date: 3/10/2022
  Time: 9:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/Lab3_war/UploadServlet" method="post" enctype="multipart/form-data">
    Image: <input type="file" name="photo_file">
    <br>
    Document: <input type="file" name="doc_file">
    <br>
    <hr>
    <button>Upload</button>


</form>

</body>
</html>
