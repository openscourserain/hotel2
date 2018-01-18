package com.seecen.sc1709.hotel.dao.impl;

import com.seecen.sc1709.hotel.dao.CCDeptDao;
import com.seecen.sc1709.hotel.entity.CCDept;
import com.seecen.sc1709.hotel.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CCDeptDaoImpl implements CCDeptDao {
    @Override
    public void add(CCDept dept) {
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet set = null;
        try {
            String[] columns = {"deptno"};
            ps=conn.prepareStatement("insert into CCDEPT " +
                    "values(CCEMP_SEQ.nextval,?,?)",columns);
            ps.setString(1,dept.getDname());
            ps.setString(2,dept.getLoc());
            //返回值是sql执行受影响的行数
            ps.executeUpdate();
            set = ps.getGeneratedKeys();//获取主键的方法
            while (set.next()){            //列名
                dept.setDeptno(set.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn,ps,set);
        }

    }

    @Override
    public boolean delete(int deptno) {
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet set = null;
        try {
            ps= conn.prepareStatement("DELETE FROM CCDEPT WHERE DEPTNO=?");
            ps.setInt(1,deptno);
            //返回值是sql执行受影响的行数
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
    public boolean update(CCDept dept) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet set = null;
        try {
            conn = JDBCUtil.getConnection();
            stm = conn.prepareStatement("update CCDEPT set DNAME=?, LOC=? where DEPTNO=?");
            stm.setString(1, dept.getDname());
            stm.setString(2, dept.getLoc());
            stm.setInt(3,dept.getDeptno());
            int result = stm.executeUpdate();
            if(result>0){
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
    public CCDept findById(int deptno) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet set = null;
       CCDept dept = null;
        try {
            conn = JDBCUtil.getConnection();
            stm = conn.prepareStatement("select * from CCDEPT where DEPTNO=?");
            stm.setInt(1, deptno);
            set = stm.executeQuery();
            while (set.next()){
                dept = new CCDept();
                dept.setDeptno(deptno);
                dept.setDname(set.getString("dname"));
                dept.setLoc(set.getString("loc"));
            }
            return dept;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn, stm, set);
        }
        return dept;

    }

    @Override
    public List<CCDept> findlist(String keyword) {

        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet set = null;
        List<CCDept> list = null;
        try {
            conn = JDBCUtil.getConnection();
            stm = conn.prepareStatement("select * from CCDEPT where CCDEPT.DNAME like ?");
            stm.setString(1, "%"+keyword+"%");
            set = stm.executeQuery();
            list= new ArrayList<>();
            while (set.next()){
                CCDept dept = new CCDept();
                dept.setDeptno(set.getInt("deptno"));
                dept.setDname(set.getString("dname"));
                dept.setLoc(set.getString("loc"));
                list.add(dept);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn, stm, set);
        }
        return list;
    }
}
