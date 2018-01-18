package com.seecen.sc1709.hotel.dao;

import com.seecen.sc1709.hotel.entity.CCDept;

import java.util.List;

public interface CCDeptDao {
    /** 添加部门*/
    public void add(CCDept dept);
    /** 根据部门ID删除*/
    public boolean delete(int deptno);
    /** 修改员工信息*/
    public boolean update(CCDept dept);
    /** 根据部门ID查找部门*/
    public CCDept findById(int deptno);
    /** 根据关键字查找部门*/
    public List<CCDept> findlist(String keyword);
}
