package com.seecen.sc1709.hotel.test;

import com.seecen.sc1709.hotel.dao.CCDeptDao;
import com.seecen.sc1709.hotel.dao.impl.CCDeptDaoImpl;
import com.seecen.sc1709.hotel.entity.CCDept;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CCDeptDaoTest {
    private CCDeptDao dao = new CCDeptDaoImpl();
    @Test
    public void addTest(){
        CCDept dept= new CCDept();
        dept.setDname("运维部");
        dept.setLoc("二路");
        dao.add(dept);
        Assert.assertTrue(dept.getDeptno()>0);
    }
   @Test
    public void deleteTest(){
       boolean result = dao.delete(5);
       Assert.assertTrue(result);
   }
   @Test
   public void updateTest(){
        CCDept dept = new CCDept(6,"开发部","三楼");
       boolean result = dao.update(dept);
        Assert.assertTrue(result);
    }
   @Test
  public void findByIdTest(){
       CCDept dept = dao.findById(6 );
       Assert.assertNotNull(dept);
  }
    @Test
   public void findlistTest(){
       List<CCDept> list = dao.findlist("开");
       Assert.assertTrue(list.size()>0);
   }
    @After
   public  void  destroy(){
      dao = null;
   }
}
