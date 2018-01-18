package com.seecen.sc1709.hotel.dao.impl;

import com.seecen.sc1709.hotel.dao.DinnerTableDao;
import com.seecen.sc1709.hotel.entity.DinnerTable;
import com.seecen.sc1709.hotel.utils.JDBCUtil;

import java.sql.*;
import java.sql.Date;
import java.util.ArrayList;

import java.util.List;
import java.util.*;

public class DinnerTableDaoImpl implements DinnerTableDao {
    @Override
    public void add(DinnerTable table) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet set = null;
        try {
            conn = JDBCUtil.getConnection();
            String[] columns = {"did"};
            stm = conn.prepareStatement("INSERT into t_dinner_TABLE " +
                    "VALUES(t_dinner_TABLE_SEQ.nextval,?,?,?)", columns);
            stm.setString(1, table.getTableName());
            stm.setInt(2, table.getTableState());
            if (table.getOrderDate() != null) {
                stm.setTimestamp(3, new Timestamp(table.getOrderDate().getTime()));
            } else {
                stm.setDate(3, null);
            }
            stm.executeUpdate();
            set = stm.getGeneratedKeys();
            while (set.next()) {
                table.setDid(set.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn, stm, set);
        }
    }

    @Override
    public boolean delete(int did) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet set = null;
        try {
            conn = JDBCUtil.getConnection();
            stm = conn.prepareStatement("delete from T_DINNER_TABLE where did=?");
            stm.setInt(1, did);
            int i = stm.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn, stm, set);
        }
        return false;
    }

    @Override
    public boolean update(DinnerTable table) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet set = null;
        try {
            conn = JDBCUtil.getConnection();
            stm = conn.prepareStatement("update T_DINNER_TABLE set TABLE_NAME=?,TABLE_STATE=?,ORDER_DATE=? WHERE DID=?");
            stm.setString(1, table.getTableName());
            stm.setInt(2, table.getTableState());
            stm.setDate(3, (Date) table.getOrderDate());
            int i = stm.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public DinnerTable findById(int did) {
        return null;
    }

    @Override
    public List<DinnerTable> findList(String keyword, java.util.Date date) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet set = null;
        List<DinnerTable> list = null;
        try {
            conn = JDBCUtil.getConnection();
            StringBuffer sb = new StringBuffer("select * from T_DINNER_TABLE t where TABLE_NAME like ?");
            if(date!=null){
                sb.append("  and ( order_date >= ? and order_date <= ?+1 )");
        }
            stm = conn.prepareStatement(sb.toString());
            stm.setString(1, "%" + keyword + "%");
            if(date!=null){
                stm.setDate(2, new Date(date.getTime()));
                stm.setDate(3, new Date(date.getTime()));
            }
            set = stm.executeQuery();
            list = new ArrayList<>();
            while (set.next()) {
                DinnerTable table = new DinnerTable();
                table.setDid(set.getInt("did"));
                table.setTableName(set.getString("table_name"));
                table.setTableState(set.getInt("table_state"));
                table.setOrderDate(set.getTimestamp("order_date"));
                list.add(table);
            }
//            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn, stm, set);
        }
        return list;
    }

    @Override
    public List<DinnerTable> findList(String keyword) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet set = null;
        List<DinnerTable> list = null;
        try {
            conn = JDBCUtil.getConnection();
            StringBuffer sb = new StringBuffer("select * from T_DINNER_TABLE t where TABLE_NAME like ?");
            stm = conn.prepareStatement(sb.toString());
            stm.setString(1, "%" + keyword + "%");
            set = stm.executeQuery();
            list = new ArrayList<>();
            while (set.next()) {
                DinnerTable table = new DinnerTable();
                table.setDid(set.getInt("did"));
                table.setTableName(set.getString("table_name"));
                table.setTableState(set.getInt("table_state"));
                table.setOrderDate(set.getTimestamp("order_date"));
                list.add(table);
            }
//            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn, stm, set);
        }
        return list;
    }
}