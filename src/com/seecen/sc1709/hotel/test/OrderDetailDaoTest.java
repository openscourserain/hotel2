package com.seecen.sc1709.hotel.test;

import com.seecen.sc1709.hotel.dao.OrderDetailDao;
import com.seecen.sc1709.hotel.dao.impl.OrderDetailDaoImpl;
import com.seecen.sc1709.hotel.entity.OrderDetail;
import oracle.jdbc.OracleDriver;
import org.junit.Assert;
import org.junit.Test;

public class OrderDetailDaoTest {
    private OrderDetailDao dao = new OrderDetailDaoImpl();
    @Test
    public void addTest(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId(4);
        orderDetail.setFoodId(3);;
        dao.add(orderDetail);
        Assert.assertTrue(orderDetail.getDetailId()>0);
    }
    @Test
    public void deleteTest(){
        boolean result = dao.delete(5);
        Assert.assertTrue(result);
    }
    @Test
    public void updateTest(){
     OrderDetail orderDetail = new OrderDetail(2,2,2,2);
       boolean result = dao.update(orderDetail);
      Assert.assertTrue(result);
    }
    @Test
    public void findOrderByIdetailIdTest(){
        OrderDetail orderDetail = dao.findOrderByIdetailId(3);
        Assert.assertNotNull(orderDetail);
    }
}
