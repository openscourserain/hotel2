package com.seecen.sc1709.hotel.servlet;

import com.seecen.sc1709.hotel.entity.Food;
import com.seecen.sc1709.hotel.service.FoodService;
import com.seecen.sc1709.hotel.service.FoodServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/food.html")
public class FoodController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        FoodService foodService = new FoodServiceImpl();
        //根据菜名查询食物列表
        String foodName = request.getParameter("foodName");
        Food food = new Food();
        food.setFoodName(foodName);
        List<Food> list = foodService.findFoods(food);
        //重定向和转换
        request.setAttribute("list",list);
        request.setAttribute("foodName",foodName);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/food/FoodList.jsp");
        rd.forward(request,response);
    }
}
