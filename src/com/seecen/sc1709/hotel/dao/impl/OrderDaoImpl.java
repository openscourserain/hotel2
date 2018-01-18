package com.seecen.sc1709.hotel.dao.impl;

import com.seecen.sc1709.hotel.dao.OrderDao;
import com.seecen.sc1709.hotel.entity.Order;
import com.seecen.sc1709.hotel.utils.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    @Override
    public void add(Order order) {
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet set = null;
        try {
            String[] columns = {"oid"};
            ps=conn.prepareStatement("insert into T_ORDERS values(T_ORDERS_SEQ.nextval,?,?,?,?)",columns);
            ps.setInt(1,order.getTableId());
            if(order.getOrderDate()!=null){
                ps.setDate(2,new Date (order.getOrderDate().getTime()));
            }else {
                ps.setDate(2, null);
            }

            ps.setDouble(3,order.getTotalPrice());
            ps.setInt(4,order.getOrderState());
           ps.executeUpdate();
           set =ps.getGeneratedKeys();
           while(set.next()){
               order.setOid(set.getInt(1));
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }  finally {
            JDBCUtil.close(conn,ps,set);
        }
    }

    @Override
    public boolean delete(int oid) {
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet set = null;
        try {
            ps=conn.prepareStatement("DELETE FROM T_ORDERS WHERE OID=?");
            ps.setInt(1,oid);
            //返回值是sql执行受影响的行数
         int result =   ps.executeUpdate();
         if(result>0){
             return true;
         }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn,ps,set);
        }
        return false;
    }

    @Override
    public boolean update(Order order) {
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet set = null;
        try {
            ps=conn.prepareStatement("UPDATE T_ORDERS SET TABLE_ID = ?,  TOTAL_PRICE = ?, ORDER_STATE = ?,ORDER_DATE = ? WHERE OID = ?");
            ps.setInt(1,order.getTableId());
            ps.setDouble(2,order.getTotalPrice());
            ps.setInt(3,order.getOrderState());
            ps.setDate(4,new Date(order.getOrderDate().getTime()));
            ps.setInt(5,order.getOid());
            int result = ps.executeUpdate();
            if(result>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn,ps,set);
        }
        return false;
    }

    @Override
    public Order findOrderById(int oid) {
        Order order = null;
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet set = null;
        try {
           ps= conn.prepareStatement("SELECT * FROM T_ORDERS WHERE OID=?");
            ps.setInt(1,oid);
            //返回值是sql执行受影响的行数
            set=ps.executeQuery();
           while(set.next()){
                order = new Order();
                order.setOid(set.getInt("oid"));
                order.setTableId(set.getInt("table_id"));
                order.setOrderDate(set.getDate("order_date"));
                order.setTotalPrice(set.getDouble("total_price"));
                order.setOrderState(set.getInt("order_state"));
            }
            return order;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn,ps,set);
        }
        return order;
    }


}
