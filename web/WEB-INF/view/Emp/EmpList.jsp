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
    <form action="/emp.html" method="post">
        <label>员工姓名<input type="text" name="ename" value="${ename}"></label>
        <label>入职时间<input type="date" name="HireDate"/> </label>
        <input type="submit" value="搜索">
    </form>
</div>
<table>
    <thead>
    <tr>
        <th>编号</th>
        <th>奖金</th>
        <th>员工名</th>
        <th>入职时间</th>
        <th>工作类型</th>
        <th>月薪</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="item">
        <tr>
            <td>${item.empno}</td>
            <td>${item.comm}</td>
            <td>${item.ename}</td>
            <td><f:formatDate value="${item.hiredate}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
            <td>${item.job}</td>
            <td>${item.sal}</td>
            <td><a href="#">修改</a><a href="#">删除</a></td>
        </tr>
    </c:forEach>
    </tbody>

</table>

</body>
</html>
