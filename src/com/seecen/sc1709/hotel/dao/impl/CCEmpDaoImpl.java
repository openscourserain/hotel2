package com.seecen.sc1709.hotel.dao.impl;

import com.seecen.sc1709.hotel.dao.CCEmpDao;
import com.seecen.sc1709.hotel.entity.CCEmp;
import com.seecen.sc1709.hotel.utils.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CCEmpDaoImpl implements CCEmpDao {
    @Override
    public void add(CCEmp emp) {
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet set = null;
        try {
            String[] columns = {"empno"};
            ps=conn.prepareStatement("insert into CCEMP values(CCEMP_SEQ.nextval,?,?,?,?,?)",columns);
            ps.setDouble(1,emp.getComm());
            ps.setString(2,emp.getEname());
            ps.setDate(3,new Date(emp.getHiredate().getTime()));
            ps.setString(4,emp.getJob());
            ps.setDouble(5,emp.getSal());
            //返回值是sql执行受影响的行数
            ps.executeUpdate();
            set = ps.getGeneratedKeys();//获取主键的方法
            while (set.next()){            //列名
                emp.setEmpno(set.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn,ps,set);
        }
    }

    @Override
    public boolean delete(int empno) {
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet set = null;
        try {
            ps= conn.prepareStatement("DELETE FROM CCEMP WHERE EMPNO=?");
            ps.setInt(1,empno);
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
    public boolean update(CCEmp emp) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet set = null;
        try {
            conn = JDBCUtil.getConnection();
            stm = conn.prepareStatement("update CCEMP set COMM=?, ENAME=?,HIREDATE=?,JOB=?,SAL=? where EMPNO=?");
            stm.setDouble(1, emp.getComm());
            stm.setString(2, emp.getEname());
            if(emp.getHiredate()!=null){
                stm.setDate(3, new Date (emp.getHiredate().getTime()));
            }else {
                stm.setDate(3,null);
            }

            stm.setString(4, emp.getJob());
            stm.setDouble(5, emp.getSal());
            stm.setInt(6,emp.getEmpno());
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
    public CCEmp findById(int empno) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet set = null;
        CCEmp emp = null;
        try {
            conn = JDBCUtil.getConnection();
            stm = conn.prepareStatement("select * from CCEMP t where EMPNO=?");
            stm.setInt(1, empno);
            set = stm.executeQuery();
            while (set.next()){
                emp = new CCEmp();
                emp.setEmpno(set.getInt("empno"));
                emp.setComm(set.getDouble("comm"));
                emp.setEname(set.getString("ename"));
                emp.setHiredate(set.getDate("hiredate"));
               emp.setJob(set.getString("job"));
                emp.setSal(set.getDouble("sal"));
            }
            return emp;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn, stm, set);
        }
        return emp;
    }



    @Override
    public List<CCEmp> findlist(String keyword) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet set = null;
        List<CCEmp> list = null;
        try {
            conn = JDBCUtil.getConnection();
            stm = conn.prepareStatement("select * from CCEMP where CCEMP.ENAME like ?");
            stm.setString(1, "%"+keyword+"%");
            set = stm.executeQuery();
            list= new ArrayList<>();
            while (set.next()){
                CCEmp emp = new CCEmp();
                emp.setEmpno(set.getInt("empno"));
                emp.setComm(set.getDouble("comm"));
                emp.setEname(set.getString("ename"));
                emp.setHiredate(set.getDate("hiredate"));
                emp.setJob(set.getString("job"));
                emp.setSal(set.getDouble("sal"));
                list.add(emp);
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
