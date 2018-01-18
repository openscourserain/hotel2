package com.seecen.sc1709.hotel.test;

import com.seecen.sc1709.hotel.dao.FoodTypeDao;
import com.seecen.sc1709.hotel.dao.impl.FoodTypeDaoImpl;
import com.seecen.sc1709.hotel.entity.FoodType;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class FoodTypeDaoTest {
    private FoodTypeDao dao = new FoodTypeDaoImpl();
    @Test
    public void addTest(){
        FoodType foodType = new FoodType();
        foodType.setTypeName("粤菜");
        dao.add(foodType);
        Assert.assertTrue(foodType.getFid()>0);
    }
    @Test
    public void deleteTest(){
        boolean result = dao.delete(6);
        Assert.assertTrue(result);
    }
    @Test
    public void updateTest(){
        FoodType foodType = new FoodType(2,"川菜");
        boolean result = dao.update(foodType);
        Assert.assertTrue(result);
    }
    @Test
    public void findFoodTypeByIdTest(){
        FoodType foodType = dao.findFoodTypeById(3);
        Assert.assertNotNull(foodType);
    }
    @Test
    public void findlistTest(){
        List<FoodType> list = dao.findlist("川");
        Assert.assertTrue(list.size()>0);
    }
    @After
    public  void  destroy(){
        dao = null;
    }

}
