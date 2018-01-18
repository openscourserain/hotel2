package com.seecen.sc1709.hotel.test;

import com.seecen.sc1709.hotel.dao.OrderDao;
import com.seecen.sc1709.hotel.dao.impl.OrderDaoImpl;
import com.seecen.sc1709.hotel.entity.Order;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;


public class OrderDaoTest {
    private OrderDao dao = new OrderDaoImpl();
    @Test
    public void addTest(){
        Order order = new Order();
        order.setTableId(4);
        order.setOrderDate(new Date());
        order.setTotalPrice(400);
        order.setOrderState(0);
        dao.add(order);
        Assert.assertTrue(order.getOid()>0);
    }
    @Test
    public void deleteTest(){
            boolean result = dao.delete(4);
            Assert.assertTrue(result);
    }
    @Test
    public void updateTest(){
        Order order = new Order();
        order.setOid(3);
        order.setTableId(2);
        order.setTotalPrice(100);
        order.setOrderDate(new Date());
        order.setOrderState(1);
        boolean result = dao.update(order);
        Assert.assertTrue(result);
    }
    @Test
    public void findOrderByIdTest(){
        Order order = dao.findOrderById(2);
        Assert.assertNotNull(order);
    }
    @After
    public  void  destroy(){
        dao = null;
    }



}
