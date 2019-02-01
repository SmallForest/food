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
        String msg = "";
        String color = "red";
        if (request.getAttribute("msg") != null) {
            msg = (String) request.getAttribute("msg");
            color = (String) request.getAttribute("color");
        }
    %>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>菜品删除(根据ID删)</title>
    <style type="text/css">

    </style>
</head>
<body>
<center>
    <h1>菜品删除(根据ID删除)</h1>
    <h6 style="color: <%=color%>;"><%=msg%>
    </h6>
    <form action="<%=basePath%>/FoodDeleteServlet" method="post">
        <table width="400px" border="1px" cellspacing="0px" cellpadding="0px">
            <tr>
                <td>菜品ID</td>
                <td><input type="text" name="id"></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align:center"><input type="submit" value="删除"></td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>
