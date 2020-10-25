package com.anue.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anue.mapper.StockMapper;
import com.anue.pojo.Stock;
import com.anue.pojo.StockKey;
import com.anue.pojo.StockPrice;
import com.anue.pojo.StockStockPrice;
import com.anue.service.StockService;

@Service
public class StockServiceImpl implements StockService{
	private static final Logger Logger = LoggerFactory.getLogger(StockServiceImpl.class);
	
	@Autowired
	StockMapper stockerMapper;
	
	@Override
	public Stock addStock(String stockName, Integer stockNo, Date updateTime, Date createTime) {
		Stock stock=new Stock();
		stock.setStockno(stockNo);
		stock.setStockname(stockName);
		stock.setUpdatetime(updateTime);
		stock.setCreatetime(createTime);
		int result=stockerMapper.insert(stock);
		Logger.debug("addStock method ,result="+result);
		if(result==1) {
			stock.setStatusCode(200);
			stock.setStatusMsg("success");
		}else {
			stock.setStatusCode(500);
			stock.setStatusMsg("error");
		}
		return stock;
	}

	@Override
	public Stock updateStockByPK(Integer stockId, String stockName, Integer stockNo, Date updateTime, Date createTime) {
		Stock stock=new Stock();
		stock.setStockid(stockId);
		stock.setStockno(stockNo);
		stock.setStockname(stockName);
		stock.setUpdatetime(updateTime);
		stock.setCreatetime(createTime);
		int result=stockerMapper.updateByPrimaryKeySelective(stock);
		if(result==1) {
			stock.setStatusCode(200);
			stock.setStatusMsg("success");
		}else {
			stock.setStatusCode(500);
			stock.setStatusMsg("error");
		}
		return stock;
	}

	@Override
	public int delStockByPK(Integer stockId, Integer stockNo) {
		StockKey stockKey=new StockKey();
		stockKey.setStockid(stockId);
		stockKey.setStockno(stockNo);
		int result=stockerMapper.deleteByPrimaryKey(stockKey);
		return result;
	}

	@Override
	public List<StockStockPrice> selectStockStockPrice(Integer stockId, String stockName, Date transDate, Date transTimeBegin, Date transTimeEnd) {
		StockStockPrice stockStockPrice=new StockStockPrice();
		StockPrice stockPrice=new StockPrice();
		stockPrice.setTransdate(transDate);
		stockStockPrice.setStockid(stockId);
		stockStockPrice.setStockname("%"+stockName+"%");
		stockStockPrice.setStockPrice(stockPrice);
		stockStockPrice.setTransTimeBegin(transTimeBegin);
		stockStockPrice.setTransTimeEnd(transTimeEnd);
		List<StockStockPrice> stockStockPriceList=stockerMapper.selectStockStockPrice(stockStockPrice);
		return stockStockPriceList;
	}

}
