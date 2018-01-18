package com.seecen.sc1709.hotel.dao.impl;

import com.seecen.sc1709.hotel.dao.FoodDao;
import com.seecen.sc1709.hotel.entity.Food;
import com.seecen.sc1709.hotel.utils.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FoodDaoImpl implements FoodDao {
    /**增加食物*/
    @Override
    public void add(Food food) {
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet set = null;
        try {
                    String[] columns = {"food_id"};
                    ps=conn.prepareStatement("insert into t_food " +
                            "values(t_food_seq.nextval,?,?,?,?,?,?)",columns);
                    ps.setString(1,food.getFoodName());
                    ps.setInt(2,food.getFoodTypeId());
                    ps.setDouble(3,food.getPrice());
                    ps.setDouble(4,food.getMprice());
                    ps.setString(5,food.getRemark());
                    ps.setString(6,food.getImg());
                    //返回值是sql执行受影响的行数
                    ps.executeUpdate();
                    set = ps.getGeneratedKeys();//获取主键的方法
                    while (set.next()){            //列名
                        food.setFoodId(set.getInt(1));
                    }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn,ps,set);
        }

    }
    /** 根据ID删除食物*/
    @Override
    public boolean delete(int fid) {
            Connection conn = JDBCUtil.getConnection();
            PreparedStatement ps = null;
            ResultSet set = null;
            try {
               ps= conn.prepareStatement("DELETE FROM T_FOOD WHERE FOOD_ID=?");
                ps.setInt(1,fid);
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
    /**更新食物信息**/
    @Override
    public boolean update(Food food) {
            //1.创建数据库连接
            //2.声明一条sql语句
            //3.设置SQL参数
            //4.执行sql语句
            //5.返回处理结果集
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet set = null;
        try {
            conn = JDBCUtil.getConnection();
            stm = conn.prepareStatement("update t_food set food_name=?, food_type_id=?,price=?,mprice=?,remark=?,img=? where food_id=?");
            stm.setString(1, food.getFoodName());
            stm.setInt(2, food.getFoodTypeId());
            stm.setDouble(3, food.getPrice());
            stm.setDouble(4, food.getMprice());
            stm.setString(5, food.getRemark());
            stm.setString(6, food.getImg());
            stm.setInt(7, food.getFoodId());
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
    /**根据ID查找食物**/
    @Override
    public Food findFoodById(int fid) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet set = null;
        Food food = null;
        try {
            conn = JDBCUtil.getConnection();
            stm = conn.prepareStatement("select * from t_food t where food_id=?");
            stm.setInt(1, fid);
            set = stm.executeQuery();
            while (set.next()){
                food = new Food();
                food.setFoodId(fid);
                food.setFoodName(set.getString("food_name"));
                food.setFoodTypeId(set.getInt("food_type_id"));
                food.setImg(set.getString("img"));
                food.setMprice(set.getDouble("mprice"));
                food.setPrice(set.getDouble("price"));
                food.setRemark(set.getString("remark"));
            }
            return food;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn, stm, set);
        }
        return food;
    }
    /**根据关键字查找食物**/
    @Override
    public List<Food> findFoods(String keyword) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet set = null;
        List<Food> list = null;
        try {
            conn = JDBCUtil.getConnection();
            stm = conn.prepareStatement("select * from t_food t where food_name like ?");
            stm.setString(1, "%"+keyword+"%");
            set = stm.executeQuery();
            list= new ArrayList<>();
            while (set.next()){
                Food food = new Food();
                food.setFoodId(set.getInt("food_id"));
                food.setFoodName(set.getString("food_name"));
                food.setFoodTypeId(set.getInt("food_type_id"));
                food.setImg(set.getString("img"));
                food.setMprice(set.getDouble("mprice"));
                food.setPrice(set.getDouble("price"));
                food.setRemark(set.getString("remark"));
                list.add(food);
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
