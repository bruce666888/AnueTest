package com.anue.mapper;

import java.util.List;

import com.anue.pojo.Stock;
import com.anue.pojo.StockExample;
import com.anue.pojo.StockKey;
import com.anue.pojo.StockStockPrice;

public interface StockMapper {
    int deleteByPrimaryKey(StockKey key);

    int insert(Stock record);

    int insertSelective(Stock record);

    List<Stock> selectByExample(StockExample example);

    Stock selectByPrimaryKey(StockKey key);

    int updateByPrimaryKeySelective(Stock record);

    int updateByPrimaryKey(Stock record);
    
    List<StockStockPrice> selectStockStockPrice(StockStockPrice stockStockPrice);
}