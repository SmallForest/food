<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="com.immoc.servlet.Food" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: dada
  Date: 2019-01-31
  Time: 21:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <%
        String basePath = request.getContextPath();
        List<Food> list = (List<Food>) request.getServletContext().getAttribute("list");
        List<Food> list1 = (List<Food>) request.getAttribute("list1");
        {
    %>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>菜品信息展示</title>
    <style type="text/css">

    </style>
</head>
<body>
<center>
    <h1>菜品查询</h1>
    <table border="1px" cellspacing="0px" cellpadding="0px" width="800px">
        <thead>
        <tr>
            <th>菜品ID</th>
            <th>菜名</th>
            <th>口味</th>
            <th>菜品图片</th>
            <th>价格</th>
            <th>菜品描述</th>
        </tr>
        </thead>
        <tbody>
        <c:choose>
            <c:when test="${list1 != null}">
                <c:forEach items="${list1}" varStatus="idx" var="item">
                    <tr>
                        <td>${item.getId()}</td>
                        <td>${item.getName()}</td>
                        <td>${item.getTaste()}</td>
                        <td><img src="<%=basePath%>${item.getUrl()}" style="width: 277px;height: 185px;" alt=""></td>
                        <td>${item.getPrice()}</td>
                        <td>${item.getDescribe()}</td>
                    </tr>
                </c:forEach>
            </c:when>
            <c:when test="${list != null}">
                <c:forEach items="${list}" varStatus="idx" var="item">
                    <tr>
                        <td>${item.getId()}</td>
                        <td>${item.getName()}</td>
                        <td>${item.getTaste()}</td>
                        <td><img src="<%=basePath%>${item.getUrl()}" style="width: 277px;height: 185px;" alt=""></td>
                        <td>${item.getPrice()}</td>
                        <td>${item.getDescribe()}</td>
                    </tr>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <tr>nothing</tr>
            </c:otherwise>
        </c:choose>

        <%
            }
        %>
        </tbody>
    </table>
</center>
</body>
</html>