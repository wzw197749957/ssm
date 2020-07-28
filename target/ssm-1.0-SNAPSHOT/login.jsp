<%--
  Created by IntelliJ IDEA.
  User: AIRSOLA
  Date: 2020/7/27
  Time: 23:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>

</body>
<center>
    <h2>用户登录</h2>
    <form action="/login" method="post">
        <table>
            <tr>
                <td>用户名：</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>密&nbsp;&nbsp;码：</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="登录">
                </td>
            </tr>
        </table>
    </form>
</center>
</html>
