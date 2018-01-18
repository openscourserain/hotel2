package com.seecen.sc1709.hotel.test;

import com.seecen.sc1709.hotel.dao.DinnerTableDao;
import com.seecen.sc1709.hotel.dao.impl.DinnerTableDaoImpl;
import com.seecen.sc1709.hotel.entity.DinnerTable;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class DinnerTableDaoTest {
    private DinnerTableDao dao = new DinnerTableDaoImpl();
    @Test
    public void addTest(){
        DinnerTable dinnerTable = new DinnerTable();
        dinnerTable.setOrderDate(new Date());
        dinnerTable.setTableName("餐桌A");
        dinnerTable.setTableState(0);
        dao.add(dinnerTable);
        Assert.assertTrue(dinnerTable.getDid()>0);

    }
    @Test
    public void deleteTest(){

     boolean result = dao.delete(4);
     Assert.assertTrue(result);
    }
    @Test
    public void updateTest(){
        DinnerTable dinnerTable = new DinnerTable(2,"餐桌1",0,null);
        boolean result = dao.update(dinnerTable);
        Assert.assertTrue(result);
    }
    @Test
    public void findlistTest(){
        List<DinnerTable> list = dao.findList("餐");
        Assert.assertTrue(list.size()>0);
    }
    @After
    public  void  destroy(){
        dao = null;
    }
}
