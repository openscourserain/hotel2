package com.seecen.sc1709.hotel.servlet;

import com.seecen.sc1709.hotel.entity.CCEmp;
import com.seecen.sc1709.hotel.service.EmpService;
import com.seecen.sc1709.hotel.service.EmpServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Emp",urlPatterns = "/emp.html")
public class EmpController extends HttpServlet {
    private EmpService empService = new EmpServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //根据员工名查询员工列表
        request.setCharacterEncoding("utf-8");

        String ename = request.getParameter("ename");
            CCEmp emp = new CCEmp();
        emp.setEname(ename);
        List<CCEmp> list = empService.findList(emp);

        //重定向和转换
        request.setAttribute("list",list);
        request.setAttribute("ename",ename);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/Emp/EmpList.jsp");
        rd.forward(request,response);
    }
}
