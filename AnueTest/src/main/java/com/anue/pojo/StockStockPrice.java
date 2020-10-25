package com.anue.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class StockStockPrice extends Stock implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private StockPrice stockPrice;

	@DateTimeFormat(pattern="HH:mm:ss")
    private Date transTimeBegin;

	@DateTimeFormat(pattern="HH:mm:ss")
    private Date transTimeEnd;
	
	private int statusCode;
	private String statusMsg;
	
	@Override
	public String toString() {
		return "Stock:"+super.toString()+";StockPrice:"+stockPrice.toString()+
		";StockStockPrice:transTimeBegin="+transTimeBegin+",transTimeEnd="+transTimeEnd+",statusMsg="+statusMsg;
	}
	
	public StockPrice getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(StockPrice stockPrice) {
		this.stockPrice = stockPrice;
	}

	public Date getTransTimeBegin() {
		return transTimeBegin;
	}

	public void setTransTimeBegin(Date transTimeBegin) {
		this.transTimeBegin = transTimeBegin;
	}

	public Date getTransTimeEnd() {
		return transTimeEnd;
	}

	public void setTransTimeEnd(Date transTimeEnd) {
		this.transTimeEnd = transTimeEnd;
	}

	public String getStatusMsg() {
		return statusMsg;
	}

	public void setStatusMsg(String statusMsg) {
		this.statusMsg = statusMsg;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
}
