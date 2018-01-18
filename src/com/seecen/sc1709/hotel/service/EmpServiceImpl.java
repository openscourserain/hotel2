package com.seecen.sc1709.hotel.service;

import com.seecen.sc1709.hotel.dao.CCEmpDao;
import com.seecen.sc1709.hotel.dao.impl.CCEmpDaoImpl;
import com.seecen.sc1709.hotel.entity.CCEmp;

import java.util.List;

public class EmpServiceImpl implements EmpService {
    private CCEmpDao empDao = new CCEmpDaoImpl();
    @Override
    public List<CCEmp> findList(CCEmp emp) {
        List<CCEmp> list = null;
        if (emp != null) {
            if (emp.getEname() != null) {
                list = empDao.findlist(emp.getEname());
            } else {
                list = empDao.findlist("");
            }
        }
        return list;
     }
    }


