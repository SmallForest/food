<%--
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
        String msg = "";
        if (request.getAttribute("msg") != null) {
            msg = (String) request.getAttribute("msg");
        }
    %>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>菜名查询</title>
    <style type="text/css">

    </style>
</head>
<body>
<center>
    <h1>菜名查询</h1>
    <h6 style="color: red;"><%=msg%></h6>
    <form action="<%=basePath%>/SelectFoodByNameServlet" method="post">
        <input type="hidden" name="type" value="2">
        <table width="400px" border="1px" cellspacing="0px" cellpadding="0px">
            <tr>
                <td>菜名</td>
                <td><input type="text" name="foodName"></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align:center">
                    <input type="submit" value="查询">
                </td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>
