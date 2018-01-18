package com.seecen.sc1709.hotel.service;

import com.seecen.sc1709.hotel.entity.CCEmp;

import java.util.List;

public interface EmpService {
    /**
     * 根据条件查询数据
     * @param emp
     * @return
     */
    public  List<CCEmp> findList(CCEmp emp);
}
