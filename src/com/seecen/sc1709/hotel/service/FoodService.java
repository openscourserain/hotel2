package com.seecen.sc1709.hotel.service;

import com.seecen.sc1709.hotel.entity.Food;

import java.util.List;

public interface FoodService {
    /**
     * 根据条件查询数据
     * @param food
     * @return
     */
    public List<Food> findFoods(Food food);
}
