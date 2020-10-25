package com.anue.pojo;

public class StockPriceKey {
    private Integer priceid;

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