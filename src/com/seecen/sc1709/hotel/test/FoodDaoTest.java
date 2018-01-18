package com.seecen.sc1709.hotel.test;

import com.seecen.sc1709.hotel.dao.FoodDao;
import com.seecen.sc1709.hotel.dao.impl.FoodDaoImpl;
import com.seecen.sc1709.hotel.entity.Food;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class FoodDaoTest {
    private  FoodDao dao;
    @Before
    public void  init(){
        dao = new FoodDaoImpl();
    }
    @Test
    public void addTest(){
         FoodDao dao = new FoodDaoImpl();
        Food food = new Food();
        food.setFoodName("饭");
        dao.add(food);
        Assert.assertTrue(food.getFoodId()>0);
    }
    @Test
    public void deleteTest(){
        FoodDao dao = new FoodDaoImpl();
        boolean result=dao.delete(9);
        Assert.assertTrue(result);

    }
    @Test
    public void updateTest(){

        Food food = new Food(2,"狗肉",1,60,48,"非常好吃","");
       boolean result= dao.update(food);
        Assert.assertTrue(result);
    }
    @Test
    public void  findByIdTest(){

        Food food = dao.findFoodById(2);
        Assert.assertNotNull(food);
    }
    @Test
    public void findFoodsTest(){
        List<Food> list = dao.findFoods("狗");
        Assert.assertTrue(list.size()>0);
    }

    @After
    public  void  destroy(){
        dao = null;
    }
}
