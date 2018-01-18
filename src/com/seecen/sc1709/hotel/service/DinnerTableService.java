package com.seecen.sc1709.hotel.service;

import com.seecen.sc1709.hotel.entity.DinnerTable;

import java.util.List;

public interface DinnerTableService {
    /**
     * 查询餐桌表数据
     * @param dinnerTable
     * @return
     */
    public List<DinnerTable> findAll(DinnerTable dinnerTable);
}
