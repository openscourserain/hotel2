package com.seecen.sc1709.hotel.servlet;

    import com.seecen.sc1709.hotel.entity.DinnerTable;
    import com.seecen.sc1709.hotel.service.DinnerTableService;
    import com.seecen.sc1709.hotel.service.DinnerTableServiceImpl;

    import javax.servlet.ServletException;
    import javax.servlet.annotation.WebServlet;
    import javax.servlet.http.HttpServlet;
    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse;
    import java.io.IOException;
    import java.text.ParseException;
    import java.text.SimpleDateFormat;
    import java.util.List;

@WebServlet(urlPatterns = "/dinnerTable.html")
public class DinnerTableController extends HttpServlet {
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("utf-8");//放置表单数据乱码
    String tableName = request.getParameter("tableName");//获取表单参数
    String orderDate = request.getParameter("orderDate");
    //根据参数查询数据
    DinnerTable  dinnerTable = new DinnerTable();
    dinnerTable.setTableName(tableName);
    if(orderDate!=null) {
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            dinnerTable.setOrderDate(df.parse(orderDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    DinnerTableService dinnerTableService = new DinnerTableServiceImpl();
    List<DinnerTable> list  = dinnerTableService.findAll(dinnerTable);
    //把数据返回页面
    request.setAttribute("list",list);
    //查询条件
    request.setAttribute("tableName",tableName);
    request.getRequestDispatcher("WEB-INF/view/dinnertable/DinnerTableList.jsp")
            .forward(request,response);


}

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    this.doPost(request,response);

}
}
