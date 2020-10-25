package com.anue.mapper;

import com.anue.pojo.StockPrice;
import com.anue.pojo.StockPriceExample;
import com.anue.pojo.StockPriceKey;
import java.util.List;

public interface StockPriceMapper {
    int deleteByPrimaryKey(StockPriceKey key);

    int insert(StockPrice record);

    int insertSelective(StockPrice record);

    List<StockPrice> selectByExample(StockPriceExample example);

    StockPrice selectByPrimaryKey(StockPriceKey key);

    int updateByPrimaryKeySelective(StockPrice record);

    int updateByPrimaryKey(StockPrice record);
}