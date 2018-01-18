package com.seecen.sc1709.hotel.service;

import com.seecen.sc1709.hotel.dao.FoodDao;
import com.seecen.sc1709.hotel.dao.impl.FoodDaoImpl;
import com.seecen.sc1709.hotel.entity.Food;

import java.util.List;

public class FoodServiceImpl implements FoodService {
    private FoodDao foodDao = new FoodDaoImpl();

    /**
     *
     * @param food
     * @return
     */
    @Override
    public List<Food> findFoods(Food food) {
        List<Food> list = null;
        if(food!=null){
            if(food.getFoodName()!=null){
                list = foodDao.findFoods(food.getFoodName());
            }else {
                list = foodDao.findFoods("");
            }
        }
        return list;
    }
}
