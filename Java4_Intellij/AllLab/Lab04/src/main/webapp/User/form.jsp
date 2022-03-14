<%--
  Created by IntelliJ IDEA.
  User: ducit
  Date: 3/13/2022
  Time: 9:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h3>User Edition</h3>
<h4>${message}</h4>
<form action="/Lab04_war/UserServlet" method="post">

    Username: <input type="text" name="username" value="${form.username}"> <br>
    Password: <input type="text" name="password" value="${form.password}"> <br>
    Username: <input type="checkbox" name="remember" ${form.remember ? 'checked':""}> Remember me ? <br>
    <button >

        Create
    </button>

</form>