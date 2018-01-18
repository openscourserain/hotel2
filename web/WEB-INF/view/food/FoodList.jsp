<%@ page import="com.seecen.sc1709.hotel.entity.Food" %>
<%@ page import="com.seecen.sc1709.hotel.dao.FoodDao" %>
<%@ page import="com.seecen.sc1709.hotel.dao.impl.FoodDaoImpl" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: OpensourceRain
  Date: 2018/1/18
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<%--/**<%--%>
    <%--FoodDao dao = new FoodDaoImpl();--%>
    <%--List<Food> list = dao.findFoods("");--%>
    <%--//把集合装到REQUEST对象中去，然后就可以用EL表达式获取--%>
    <%--//JSTL JAVA标签库--%>
    <%--request.setAttribute("list",list);--%>
<%--%>*/--%>
<div class="condition">
    <form action="/food.html" method="post">
    <label>菜名<input type="text" name="foodName" value="${foodName}"></label>
        <input type="submit" value="搜索">
    </form>
</div>
<table class="tb">
    <thead>
    <tr>
        <th>编号</th>
        <th>菜名</th>
        <th>菜系</th>
        <th>价格</th>
        <th>会员价</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="item">
    <tr>
        <td>${item.foodId}</td>
        <td>${item.foodName}</td>
        <td>${item.foodTypeId}</td>
        <td>${item.price}</td>
        <td>${item.mprice}</td>
        <td><a href="#">修改</a><a href="#">删除</a> </td>
    </tr>
    </c:forEach>
    </tbody>
    <tr>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
    </tr>
</table>
</body>
</html>
