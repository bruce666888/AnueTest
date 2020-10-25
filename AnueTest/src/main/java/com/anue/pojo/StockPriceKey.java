package com.anue.pojo;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class StockPriceKey implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer priceid;

	@NotNull(message = "股票代碼不能為空")
    private Integer fkStockid;

    public Integer getPriceid() {
        return priceid;
    }

    public void setPriceid(Integer priceid) {
        this.priceid = priceid;
    }

    public Integer getFkStockid() {
        return fkStockid;
    }

    public void setFkStockid(Integer fkStockid) {
        this.fkStockid = fkStockid;
    }
}