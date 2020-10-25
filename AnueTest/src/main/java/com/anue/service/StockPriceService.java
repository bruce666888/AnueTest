package com.anue.service;

import java.util.Date;

import com.anue.pojo.StockPrice;

public interface StockPriceService {
	public StockPrice addStockPrice(Integer fk_stockId, Date transDate, Date transTime, Integer transPrice, Integer transQuantity, Date updateTime, Date createTime);
}
