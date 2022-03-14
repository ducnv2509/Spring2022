<%--
  Created by IntelliJ IDEA.
  User: ducit
  Date: 3/13/2022
  Time: 9:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h3>User List</h3>
<table style="width:100%;">
    <thead>
    <tr>
        <th>Username</th>
        <th>Password</th>
        <th>Remember?</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${items[0].username}</td>
        <td> ${items[0].password}</td>
        <td>${items[0].remember ? 'Yes' : 'No'}</td>
    </tr>
    <tr>
        <td>${items[1].username}</td>
        <td> ${items[1].password}</td>
        <td>${items[1].remember ? 'Yes' : 'No'}</td>
    </tr>
    <tr>
        <td>${items[2].username}</td>
        <td> ${items[2].password}</td>
        <td>${items[2].remember ? 'Yes' : 'No'}</td>
    </tr>
    </tbody>
</table>
