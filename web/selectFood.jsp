<%--
  Created by IntelliJ IDEA.
  User: dada
  Date: 2019-01-31
  Time: 21:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <%
        String basePath = request.getContextPath();
    %>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>菜品查询选项页面</title>
    <style type="text/css">

    </style>
</head>
<body>
<center>
    <p><a href="<%=basePath%>/selectFoodServlet">查询所有菜品信息</a></p>
    <p><a href="<%=basePath%>/selectFoodByName.jsp">菜名查询</a></p>
</center>
</body>
</html>
