package com.anue.service;

import java.util.Date;
import java.util.List;

import com.anue.pojo.Stock;
import com.anue.pojo.StockStockPrice;

public interface StockService {
	public Stock addStock(String stockName, Integer stockNo, Date updateTime, Date createTime);
	public Stock updateStockByPK(Integer stockId, String stockName, Integer stockNo, Date updateTime, Date createTime);
	public int delStockByPK(Integer stockId, Integer stockNo);
	public List<StockStockPrice> selectStockStockPrice(Integer stockId, String stockName, Date transDate, Date transTimeBegin, Date transTimeEnd);
}
