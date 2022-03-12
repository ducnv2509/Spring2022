<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<div class="col-5">
    <h3>Thong Tin Dang Dang Ky</h3>
    <ul>
        <li><img src="/demo/${staff.imageName}" alt="" class="img-fluid"
                 width="150" height="200"/></li>
        <li>Ten Dang Nhap: ${staff.username}</li>
        <li>Mat Khau: ${staff.password}</li>
        <li>gioitinh: ${staff.gender ? 'Nam' : 'Nu'}</li>
        <li>Lap gia dinh ${staff.married ? 'Da Co Gia Dinh' : 'Chua co gia dinh'}</li>
        <li>QUoc tich: ${staff.natinonality}</li>
        <li>So Thich: ${staff.favorites}</li>
        <li>Ghi Chu: ${staff.note}</li>
    </ul>
</div>
</body>
</html>