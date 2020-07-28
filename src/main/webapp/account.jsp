<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Account</title>
</head>
<body>
<c:forEach items="${list}" var="a">
    <c:out value="${a.cardNo}"/>
    <c:out value="${a.name}"/>
    <c:out value="${a.money}"/>
    <a href="http://localhost:8080/update?cardNo=${a.cardNo}&name=${a.name}&money=${a.money}">修改</a>
    <a href="http://localhost:8080/delete?cardNo=${a.cardNo}">删除</a>
    <br/>
</c:forEach>
</body>
</html>
