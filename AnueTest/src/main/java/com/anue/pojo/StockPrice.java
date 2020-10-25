package com.anue.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

public class StockPrice extends StockPriceKey implements Serializable{
	private static final long serialVersionUID = 1L;

	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date transdate;

	@DateTimeFormat(pattern="HH:mm:ss")
    private Date transtime;

	@NotNull(message = "交易價格不能為空")
	@Range(min = 1, max = 5000, message = "交易價格Range為1到5000")
    private Integer transprice;

	@NotNull(message = "交易量不能為空")
	@Range(min = 1, max = 1000000, message = "交易量Range為1到1000000")
    private Integer transquantity;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updatetime;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createtime;

    private int statusCode;
    private String statusMsg;
    
    @Override
	public String toString() {
		return String.format("priceId=%s,fk_stockId=%s,transDate=%s,transTime=%s,transPrice=%s,transQuantity=%s,updatetime=%s,createtime=%s,statusCode=%s,statusMsg=%s", 
				getPriceid(),getFkStockid(),transdate,transtime,transprice,transquantity,updatetime,createtime,statusCode,statusMsg);
	}
    
    
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