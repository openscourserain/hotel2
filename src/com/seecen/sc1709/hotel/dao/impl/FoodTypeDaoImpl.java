package com.seecen.sc1709.hotel.dao.impl;

import com.seecen.sc1709.hotel.dao.FoodTypeDao;
import com.seecen.sc1709.hotel.entity.FoodType;
import com.seecen.sc1709.hotel.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FoodTypeDaoImpl implements FoodTypeDao {
    @Override
    public void add(FoodType foodType) {
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet set = null;
        try {
            String[] columns = {"fid"};
            ps=conn.prepareStatement("insert into t_food_type values(t_food_type_seq.nextval,?)",columns);
            ps.setString(1,foodType.getTypeName());
            ps.executeUpdate();
            set = ps.getGeneratedKeys();
            while (set.next()){
                foodType.setFid(set.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn,ps,set);
        }
    }

    @Override
    public boolean delete(int fid) {
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet set = null;
        try {
            ps=conn.prepareStatement("DELETE FROM T_FOOD_TYPE WHERE FID=?");
            ps.setInt(1,fid);
            //返回值是sql执行受影响的行数
          int i =  ps.executeUpdate();
          if(i>0){
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
    public boolean update(FoodType foodType) {
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet set = null;
        try {
            ps=conn.prepareStatement("UPDATE T_FOOD_TYPE set TYPE_NAME=? WHERE FID=?");
            ps.setString(1,foodType.getTypeName());
            ps.setInt(2,foodType.getFid());
           int i= ps.executeUpdate();
           if(i>0){
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
    public FoodType findFoodTypeById(int fid) {
        FoodType foodType = null;
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet set = null;
        try {
            ps=conn.prepareStatement("SELECT * FROM T_FOOD_TYPE WHERE FID=?");
            ps.setInt(1,fid);
            //返回值是sql执行受影响的行数
           set= ps.executeQuery();
            if(set.next()){
                foodType= new FoodType();
                foodType.setFid(set.getInt("fid"));
                foodType.setTypeName(set.getString("type_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn,ps,set);
        }
        return foodType;
    }

    @Override
    public List<FoodType>findlist(String keyword) {
        List<FoodType> list = null;
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet set = null;
        try {
            ps=conn.prepareStatement("SELECT * FROM T_FOOD_TYPE WHERE TYPE_NAME like ? ");
            ps.setString(1,"%"+keyword+"%");
            //返回值是sql执行受影响的行数
           set= ps.executeQuery();
           list = new ArrayList<>();
            while (set.next()){
                    FoodType foodType = new FoodType();
                foodType.setFid(set.getInt("FID"));
                foodType.setTypeName(set.getString("TYPE_NAME"));
                list.add(foodType);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn,ps,set);
        }
        return list;
    }
}
