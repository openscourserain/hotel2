package com.seecen.sc1709.hotel.test;

import com.seecen.sc1709.hotel.dao.CCEmpDao;
import com.seecen.sc1709.hotel.dao.impl.CCEmpDaoImpl;
import com.seecen.sc1709.hotel.entity.CCEmp;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class CCEmpDaoTest {
    private CCEmpDao dao = new CCEmpDaoImpl();
    @Test
    public void addTest(){
        CCEmp emp = new CCEmp();
        emp.setComm(1000);
        emp.setEname("老王");
        emp.setHiredate(new Date());
        emp.setJob("程序员");
        emp.setSal(10000);
        dao.add(emp);
        Assert.assertTrue(emp.getEmpno()>0);
    }
    @Test
    public void deleteTest(){
        boolean result = dao.delete(3);
        Assert.assertTrue(result);
    }
    @Test
    public void updateTest(){
        CCEmp emp = new CCEmp(2,10000,"老李",null,"泥工",10000);
        boolean result = dao.update(emp);
        Assert.assertTrue(result);
    }
    @Test
    public void findByIdTest(){
        CCEmp emp = dao.findById(2  );
        Assert.assertNotNull(emp);
    }
    @Test
    public void findlistTest(){
        List<CCEmp> list = dao.findlist("");
        System.out.println(list);
        Assert.assertTrue(list.size()>0);
    }
    @After
    public  void  destroy(){
        dao = null;
    }

}
