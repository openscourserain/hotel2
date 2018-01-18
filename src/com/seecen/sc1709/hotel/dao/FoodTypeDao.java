package com.seecen.sc1709.hotel.dao;

import com.seecen.sc1709.hotel.entity.FoodType;

import java.util.List;

public interface FoodTypeDao {
    /**增加菜系*/
    public void add(FoodType foodType);
    /** 根据ID删除菜系*/
    public boolean delete(int fid);
    /**更新菜系信息**/
    public boolean update(FoodType foodType);
    /**根据ID查找菜系**/
    public FoodType findFoodTypeById(int fid);
    /**根据关键字查找菜系**/
    public List<FoodType> findlist(String keyword);
}
