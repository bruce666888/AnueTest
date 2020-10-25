package com.anue.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anue.pojo.Stock;
import com.anue.pojo.StockPrice;
import com.anue.pojo.StockStockPrice;
import com.anue.redis.RedisService;
import com.anue.service.StockPriceService;
import com.anue.service.StockService;
import com.anue.util.SerializeUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = {"Anue API"})
public class AnueController {
	private static final Logger Logger = LoggerFactory.getLogger(AnueController.class);
	
	@Autowired
	private StockService stockService;
	@Autowired
	private StockPriceService stockPriceService;
	@Autowired
	private RedisService redisService;
	
	@ApiOperation(value = "新增股票主檔")
	@PostMapping("/addStock")
	public Stock addStock(@Valid Stock stockParams, BindingResult bindingResult){
		Logger.debug(String.format("into addStock methos,stockName=%s, stockNo=%s, updateTime=%s, createTime=%s", 
				stockParams.getStockname(),stockParams.getStockno(),stockParams.getUpdatetime(),stockParams.getCreatetime()));
		
		Stock stock=null;
		try {
			//傳入參數有誤則回傳錯誤訊息
			if (bindingResult.hasErrors()) {
	            StringBuffer errorMessage = new StringBuffer("參數驗證有誤：");
	            for (ObjectError error : bindingResult.getAllErrors()) {
	                errorMessage = errorMessage.append(error.getDefaultMessage()).append(";");
	            }
	            Logger.debug("addStock methos param error,error msgs="+errorMessage.toString());
	            stock=new Stock();
	            stock.setStatusCode(400);
	            stock.setStatusMsg(errorMessage.toString());
	            return stock;
	        }
			
			stock=stockService.addStock(stockParams.getStockname(), stockParams.getStockno(), stockParams.getUpdatetime(), stockParams.getCreatetime());
		} catch (Exception e) {
			Logger.error(e.toString());
			stock=new Stock();
			stock.setStatusCode(500);
			stock.setStatusMsg("error");
		}
		return stock;
	}
	
	@ApiOperation(value = "修改股票主檔")
	@PostMapping("/updateStock")
	public Stock updateStockByPK(Integer stockid, String stockname, Integer stockno, String updatetime, String createtime){
		Logger.debug(String.format("into updateStockByPK methos,stockId=%s, stockName=%s, stockNo=%s, updateTime=%s, createTime=%s", 
																stockid,stockname,stockno,updatetime,createtime));
		
		Stock stock=null;
		try {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date updateTimeDate=updatetime!=null ? sdf.parse(updatetime): null;
			Date createTimeDate=createtime!=null ? sdf.parse(createtime): null;
			stock=stockService.updateStockByPK(stockid,stockname, stockno, updateTimeDate, createTimeDate);
		} catch (ParseException e) {
			Logger.error(e.toString());
			stock=new Stock();
			stock.setStatusMsg("error");
		}
		return stock;
	}
	
	@ApiOperation(value = "刪除股票主檔")
	@PostMapping("/delStock")
	public String delStockByPK(Integer stockid, Integer stockno){
		Logger.debug(String.format("into delStockByPK methos,stockId=%s, stockNo=%s", stockid,stockno));
		int result=stockService.delStockByPK(stockid,stockno);
		return "{'result': "+result+"}";
	}
	
	
	@ApiOperation(value = "新增股票價格主檔")
	@PostMapping("/addStockPrice")
	public StockPrice addStockPrice(@Valid StockPrice stockPriceParams, BindingResult bindingResult) {
		Logger.debug(String.format("into addStockPrice method,fk_stockId=%s, transDate=%s, transTime=%s, transPrice=%s, transQuantity=%s, updateTime=%s, createTime=%s", 
													stockPriceParams.getFkStockid(),stockPriceParams.getTransdate(),stockPriceParams.getTranstime(),stockPriceParams.getTransprice(),
													stockPriceParams.getTransquantity(),stockPriceParams.getUpdatetime(),stockPriceParams.getCreatetime()));
		
		
		StockPrice stockPrice=null;
		try {
			//傳入參數有誤則回傳錯誤訊息
			if (bindingResult.hasErrors()) {
	            StringBuffer errorMessage = new StringBuffer("參數驗證有誤：");
	            for (ObjectError error : bindingResult.getAllErrors()) {
	                errorMessage = errorMessage.append(error.getDefaultMessage()).append(";");
	            }
	            Logger.debug("addStockPrice methos param error,error msgs="+errorMessage.toString());
	            stockPrice=new StockPrice();
	            stockPrice.setStatusCode(400);
	            stockPrice.setStatusMsg(errorMessage.toString());
	            return stockPrice;
	        }
			
			stockPrice=stockPriceService.addStockPrice(stockPriceParams.getFkStockid(), stockPriceParams.getTransdate(), stockPriceParams.getTranstime(), stockPriceParams.getTransprice(), stockPriceParams.getTransquantity(), stockPriceParams.getUpdatetime(), stockPriceParams.getCreatetime());
		} catch (Exception e) {
			Logger.error(e.toString());
			stockPrice=new StockPrice();
			stockPrice.setStatusCode(500);
			stockPrice.setStatusMsg("error");
		}
		return stockPrice;
	}
	
	@ApiOperation(value = "提供查詢價格資料的Restful API")
	@PostMapping("/selectStockStockPrice")
	public List<StockStockPrice> selectStockStockPrice(Integer stockid, String stockname, String transdate, String transTimeBegin, String transTimeEnd) {
		Logger.debug(String.format("into selectStockStockPrice method,stockId=%s, stockName=%s, transDate=%s, transTimeBegin=%s, transTimeEnd=%s",	stockid,stockname,transdate,transTimeBegin,transTimeEnd));
		String stockIdStr=stockid!=null ? String.valueOf(stockid) : null;
		List<StockStockPrice> stockStockPriceList=null;
		try {
			//判斷Redis緩存是否有值,如果有直接從Redis取出
			String redisKey=combineKey(stockIdStr, stockname, transdate, transTimeBegin, transTimeEnd);
			byte[] redisSearchResultByte=redisService.getData(redisKey.getBytes());
			//Redis查詢不到值,去DB取值
			if(redisSearchResultByte==null) {
				SimpleDateFormat sdf_date=new SimpleDateFormat("yyyy-MM-dd");
				SimpleDateFormat sdf_time=new SimpleDateFormat("HH:mm:ss");
				Date transDateDate=transdate!=null ? sdf_date.parse(transdate) : null;
				Date transTimeBeginDate=transTimeBegin!=null ? sdf_time.parse(transTimeBegin) : null;
				Date transTimeEndDate=transTimeEnd!=null ? sdf_time.parse(transTimeEnd) : null;
				stockStockPriceList=stockService.selectStockStockPrice(stockid, stockname, transDateDate, transTimeBeginDate, transTimeEndDate);
				//存入Redis
				if(stockStockPriceList.size() > 0) {
					String insertRedisResult=redisService.setData(redisKey.getBytes(), SerializeUtil.serialize(stockStockPriceList));
					Logger.debug(String.format("insertRedisResult ,redisKey=%s, insertRedisResult=%s", redisKey,insertRedisResult));
					
				}
			}else{
				stockStockPriceList=(List<StockStockPrice>) SerializeUtil.unserialize(redisSearchResultByte);
			}
		} catch (ParseException e) {
			Logger.error(e.toString());
			stockStockPriceList=new ArrayList<StockStockPrice>();
			StockStockPrice stockStockPrice=new StockStockPrice();
			stockStockPrice.setStatusCode(500);
			stockStockPrice.setStatusMsg(e.toString());
			stockStockPriceList.add(stockStockPrice);
		} catch (Exception e) {
			Logger.error(e.toString());
			stockStockPriceList=new ArrayList<StockStockPrice>();
			StockStockPrice stockStockPrice=new StockStockPrice();
			stockStockPrice.setStatusCode(500);
			stockStockPrice.setStatusMsg(e.toString());
			stockStockPriceList.add(stockStockPrice);
		} finally {
			return stockStockPriceList;
		}
	}
	
	private String combineKey(String stockId, String stockName, String transDate, String transTimeBegin, String transTimeEnd) {
		StringBuffer sb=new StringBuffer();
		if(stockId!=null && !"".equals(stockId)) {
			sb.append(stockId+",");
		}
		if(stockName!=null && !"".equals(stockName)) {
			sb.append(stockName+",");
		}
		if(transDate!=null && !"".equals(transDate)) {
			sb.append(transDate+",");
		}
		if(transTimeBegin!=null && !"".equals(transTimeBegin)) {
			sb.append(transTimeBegin+",");
		}
		if(transTimeEnd!=null && !"".equals(transTimeEnd)) {
			sb.append(transTimeEnd+",");
		}
		return sb.toString();
	}
}
