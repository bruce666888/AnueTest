package com.anue.pojo;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

public class StockKey implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer stockid;
	
	@NotNull(message = "股票代碼不能為空")
	@Range(min = 1, max = 30000, message = "股票代碼Range為1到30000")
    private Integer stockno;

    public Integer getStockid() {
        return stockid;
    }

    public void setStockid(Integer stockid) {
        this.stockid = stockid;
    }

    public Integer getStockno() {
        return stockno;
    }

    public void setStockno(Integer stockno) {
        this.stockno = stockno;
    }
}