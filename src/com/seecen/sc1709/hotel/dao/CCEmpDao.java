package com.seecen.sc1709.hotel.dao;

import com.seecen.sc1709.hotel.entity.CCEmp;

import java.util.List;

public interface CCEmpDao {
    /** 添加员工*/
    public void add(CCEmp emp);
    /** 根据员工ID删除*/
    public boolean delete(int empno);
    /**更新员工信息*/
    public boolean update(CCEmp emp);
    /**根据员工ID查询员工*/
    public CCEmp findById(int empno);
    /**根据关键字查询员工 */
    public List<CCEmp> findlist(String keyword);


}
