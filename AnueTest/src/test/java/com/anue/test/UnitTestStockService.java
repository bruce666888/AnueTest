package com.anue.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.anue.pojo.Stock;
import com.anue.pojo.StockPrice;
import com.anue.pojo.StockStockPrice;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UnitTestStockService {
	private static final Logger Logger = LoggerFactory.getLogger(UnitTestStockService.class);
	@Autowired
	private TestRestTemplate testRestTemplate;
	
	//Post參數
	MultiValueMap<String, Object> paramMap;
	
	HttpEntity<MultiValueMap> httpEntity;
	
	@BeforeEach
	void setUp() {
		paramMap=new LinkedMultiValueMap<String, Object>();
	}
	
	@Disabled
	@Test
	void testAddStock() {
		Logger.debug("into testAddStock method");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//post參數
		paramMap.add("stockname", "聯發科");
		paramMap.add("stockno", 2454);
		paramMap.add("updatetime", sdf.format(new Date()));
		paramMap.add("createtime", sdf.format(new Date()));
		httpEntity=new HttpEntity<MultiValueMap>(paramMap);
		ResponseEntity<Stock> responseEntity=testRestTemplate.postForEntity("http://localhost:8080/addStock",httpEntity, Stock.class);
		
		Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertNotNull(responseEntity.getBody());
        Stock returnStock=responseEntity.getBody();
        Logger.debug("testAddStock method,Stock toStr="+returnStock.toString());
        Assertions.assertEquals("success", returnStock.getStatusMsg());
	}

	@Disabled
	@Test
	void testUpdateStock() {
		Logger.debug("into testUpdateStock method");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//post參數
		paramMap.add("stockid", 1);
		paramMap.add("stockno", 2454);
		paramMap.add("stockname", "聯發科_1");
		paramMap.add("updatetime", sdf.format(new Date()));
		httpEntity=new HttpEntity<MultiValueMap>(paramMap);
		ResponseEntity<Stock> responseEntity=testRestTemplate.postForEntity("http://localhost:8080/updateStock",httpEntity, Stock.class);
		
		Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertNotNull(responseEntity.getBody());
        Stock returnStock=responseEntity.getBody();
        Logger.debug("testUpdateStock method,Stock toStr="+returnStock.toString());
        Assertions.assertEquals("success", returnStock.getStatusMsg());
	}
	
	@Disabled
	@Test
	void testDelStock() {
		Logger.debug("into testDelStock method");
		//post參數
		paramMap.add("stockid", 9);
		paramMap.add("stockno", 2454);
		httpEntity=new HttpEntity<MultiValueMap>(paramMap);
		ResponseEntity<String> responseEntity=testRestTemplate.postForEntity("http://localhost:8080/delStock",httpEntity, String.class);
		Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertNotNull(responseEntity.getBody());
        String resurnBodyStr=responseEntity.getBody();
        Logger.debug("testDelStock resurnBodyStr="+resurnBodyStr);
        Assertions.assertEquals("{'result': 1}", resurnBodyStr);
	}
	
	@Disabled
	@Test
	void testAddStockPrice() {
		Logger.debug("into testAddStockPrice method");
		SimpleDateFormat sdf_date=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf_time=new SimpleDateFormat("HH:mm:ss");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//post參數
		paramMap.add("fkStockid", 1);
		paramMap.add("transdate", sdf_date.format(new Date()));
		paramMap.add("transtime", sdf_time.format(new Date()));
		paramMap.add("transprice", 66);
		paramMap.add("transquantity", 88);
		paramMap.add("updatetime", sdf.format(new Date()));
		paramMap.add("createtime", sdf.format(new Date()));
		httpEntity=new HttpEntity<MultiValueMap>(paramMap);
		ResponseEntity<StockPrice> responseEntity=testRestTemplate.postForEntity("http://localhost:8080/addStockPrice",httpEntity, StockPrice.class);
		
		Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertNotNull(responseEntity.getBody());
        StockPrice returnStockPrice=responseEntity.getBody();
        Logger.debug("testAddStockPrice method,StockPrice toStr="+returnStockPrice.toString());
        Assertions.assertEquals("success", returnStockPrice.getStatusMsg());
	}
	
//	@Disabled
	@Test
	void testSelectStockStockPrice() throws ParseException {
		Logger.debug("into testSelectStockStockPrice method");
		SimpleDateFormat sdf_date=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf_time=new SimpleDateFormat("HH:mm:ss");
		
		//post參數
		paramMap.add("stockid", 8);
		paramMap.add("stockname", "科");
		paramMap.add("transdate", sdf_date.format(sdf_date.parse("2020-10-25")));
		paramMap.add("transTimeBegin", sdf_time.format(sdf_time.parse("13:01:01")));
		paramMap.add("transTimeEnd", sdf_time.format(sdf_time.parse("19:01:01")));
		httpEntity=new HttpEntity<MultiValueMap>(paramMap);
		ResponseEntity<StockStockPrice[]> responseEntity=testRestTemplate.postForEntity("http://localhost:8080/selectStockStockPrice",httpEntity, StockStockPrice[].class);
		
		Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertNotNull(responseEntity.getBody());
        StockStockPrice[] returnStockStockPriceArray=responseEntity.getBody();
        for(StockStockPrice po:returnStockStockPriceArray) {
        	 Logger.debug("testSelectStockStockPrice method,StockStockPrice toStr="+po.toString());
        }
       
        Assertions.assertTrue(returnStockStockPriceArray.length > 0);
	}
}
