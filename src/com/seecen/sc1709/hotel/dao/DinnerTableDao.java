package com.seecen.sc1709.hotel.dao;

import com.seecen.sc1709.hotel.entity.DinnerTable;

import java.util.Date;
import java.util.List;

public interface DinnerTableDao {
    /**增加餐桌**/
    public void add(DinnerTable table);
    /**删除餐桌**/
    public boolean delete(int did);
    /**修改餐桌**/
    public boolean update(DinnerTable table);
    /**根据ID查询餐桌**/
    public DinnerTable findById(int did);
    /**根据关键字查询餐桌**/
    public List<DinnerTable> findList(String key);
    /**根据关键字查询餐桌**/
    public List<DinnerTable> findList(String key, Date date);

}
