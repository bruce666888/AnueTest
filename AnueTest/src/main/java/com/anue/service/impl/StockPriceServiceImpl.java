package com.anue.service.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anue.mapper.StockPriceMapper;
import com.anue.pojo.StockPrice;
import com.anue.service.StockPriceService;

@Service
public class StockPriceServiceImpl implements StockPriceService {
	private static final Logger Logger = LoggerFactory.getLogger(StockPriceServiceImpl.class);
	
	@Autowired
	StockPriceMapper stockPriceMapper;
	
	@Override
	public StockPrice addStockPrice(Integer fk_stockId, Date transDate, Date transTime, Integer transPrice, Integer transQuantity, Date updateTime, Date createTime) {
		StockPrice stockPrice=new StockPrice();
		stockPrice.setFkStockid(fk_stockId);
		stockPrice.setTransdate(transDate);
		stockPrice.setTranstime(transTime);
		stockPrice.setTransprice(transPrice);
		stockPrice.setTransquantity(transQuantity);
		stockPrice.setUpdatetime(updateTime);
		stockPrice.setCreatetime(createTime);
		int result=stockPriceMapper.insert(stockPrice);
		Logger.debug("addStockPrice method ,result="+result);
		if(result==1) {
			stockPrice.setStatusCode(200);
			stockPrice.setStatusMsg("success");
		}else {
			stockPrice.setStatusCode(500);
			stockPrice.setStatusMsg("error");
		}
		return stockPrice;
	}

}
