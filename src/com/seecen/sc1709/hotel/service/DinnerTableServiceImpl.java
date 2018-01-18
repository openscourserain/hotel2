package com.seecen.sc1709.hotel.service;

import com.seecen.sc1709.hotel.dao.DinnerTableDao;
import com.seecen.sc1709.hotel.dao.impl.DinnerTableDaoImpl;
import com.seecen.sc1709.hotel.entity.DinnerTable;

import java.util.List;

public class DinnerTableServiceImpl implements DinnerTableService {
    private DinnerTableDao dinnerTableDao = new DinnerTableDaoImpl() ;
    @Override
    public List<DinnerTable> findAll(DinnerTable dinnerTable) {
        List<DinnerTable> list = null;
        if(dinnerTable!=null){
                //餐桌名
            if(dinnerTable.getTableName()!=null){
                list = dinnerTableDao.findList(dinnerTable.getTableName());
            }else {
                list = dinnerTableDao.findList("");
            }
            //预定时间
            if(dinnerTable.getOrderDate()!=null){
                list = dinnerTableDao.findList(dinnerTable.getTableName(), dinnerTable.getOrderDate());
            }else{
                list = dinnerTableDao.findList("");
            }
        }
        return list;
    }
}
