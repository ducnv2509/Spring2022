<%@ page pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lab01</title>
    <style>
        .main {
            width: 300px;
            height: 160px;
            border: 1px solid orange;
            margin: 0 auto;
            padding: 20px;
        }
    </style>
</head>

<body>
<div class="main">
    <form action="/Lab01/HinhChuNhat" method="post">
        <h3>Thông tin hình chữ nhật</h3>
        <table>
            <tr>
                <td>Chiều Rộng:</td>
                <td>
                    <input name="rong" type="text">
                </td>
            </tr>
            <tr>
                <td>Chiều Dài:</td>
                <td>
                    <input name="dai" type="text">
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="submit">
                </td>
            </tr>
        </table>
    </form>
</div>

</body>

</html>