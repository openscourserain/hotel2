<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: OpensourceRain
  Date: 2018/1/18
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">

<head>
    <title>Title</title>
    <style>
        .condition{
            width: 80%;
            margin: 0 auto;
            height: 50px;
            line-height: 50px;
        }
        .tb{
            width: 80%;
            margin: 0 auto;
            border: 1px solid #666666;
        }
        .tb td{
            text-align: center;
        }
    </style>
</head>
<body>
<div class="condition">
    <form action="/dinnerTable.html" method="post">
        <label>桌名<input type="text" name="tableName" value="${tableName}"></label>
        <label>预定时间<input type="date" name="orderDate"/> </label>
        <input type="submit" value="搜索">
    </form>
</div>
<table>
    <thead>
    <tr>
        <th>编号</th>
        <th>桌名</th>
        <th>状态</th>
        <th>预定时间</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="item">
    <tr>
        <td>${item.did}</td>
        <td>${item.tableName}</td>
        <td><c:if test="${item.tableState==1}">已预定</c:if>
            <c:if test="${item.tableState==0}">未预定</c:if>
        </td>
        <td><f:formatDate value="${item.orderDate}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
        <td><a href="#">修改</a><a href="#">删除</a></td>
    </tr>
    </c:forEach>
    </tbody>

</table>

</body>
</html>
