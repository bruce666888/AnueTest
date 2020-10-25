package com.anue.pojo;

import java.util.Date;

public class StockPrice extends StockPriceKey {
    private Date transdate;

    private Date transtime;

    private Integer transprice;

    private Integer transquantity;

    private Date updatetime;

    private Date createtime;

    public Date getTransdate() {
        return transdate;
    }

    public void setTransdate(Date transdate) {
        this.transdate = transdate;
    }

    public Date getTranstime() {
        return transtime;
    }

    public void setTranstime(Date transtime) {
        this.transtime = transtime;
    }

    public Integer getTransprice() {
        return transprice;
    }

    public void setTransprice(Integer transprice) {
        this.transprice = transprice;
    }

    public Integer getTransquantity() {
        return transquantity;
    }

    public void setTransquantity(Integer transquantity) {
        this.transquantity = transquantity;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}