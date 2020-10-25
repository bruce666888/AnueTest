package com.anue.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


public class Stock extends StockKey implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@NotBlank(message = "股票名字不能為空")
	@Size(max = 200, message = "股票長度最長為200")
	private String stockname;

	@NotNull(message = "更新日期不能為空")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updatetime;

	@NotNull(message = "建立日期不能為空")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createtime;
    
    private int statusCode;
    private String statusMsg;

    @Override
	public String toString() {
		return String.format("stockId=%s,stockName=%s,stockNo=%s,updateTime=%s,createTime=%s,statusCode=%s,statusMsg=%s", getStockid(),stockname,getStockno(),updatetime,createtime,statusCode,statusMsg);
	}
    
    public String getStockname() {
        return stockname;
    }

    public void setStockname(String stockname) {
        this.stockname = stockname == null ? null : stockname.trim();
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