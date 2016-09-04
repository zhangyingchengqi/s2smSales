package com.yc.bean;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SaleOrder implements java.io.Serializable {

	private static final long serialVersionUID = 1056218493209950488L;
	private Long odrId;
	private Long odrCustomerId = 0L;
	private String odrCustomerName;
	private String odrDeliverAddr;
	
	
	
	private Date odrOrderDate = new Date(new java.util.Date().getTime());
	private Date odrDeliverDate = new Date(new java.util.Date().getTime());
	
	
	private String odrStatus;
	
	
	private List<SaleOrderLine> saleOrderLines;
	
	
	private String odrOrderDateString;
	private String odrDeliverDateString;
	
	
	private SaleOrderLine saleOrderLine;   //订单项添加功能时用的.
	
	
	
	
	

	
	
	
	public SaleOrderLine getSaleOrderLine() {
		return saleOrderLine;
	}

	public void setSaleOrderLine(SaleOrderLine saleOrderLine) {
		this.saleOrderLine = saleOrderLine;
	}
	//将数据库中的下订时间 转为   String
	public String getOdrOrderDateString() {
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd");;
		this.odrOrderDateString=df.format(   new java.util.Date(  this.odrOrderDate.getTime())      );
		return this.odrOrderDateString;
	}

	public void setOdrOrderDateString(String odrOrderDateString) {
		this.odrOrderDateString = odrOrderDateString;
	}

	public String getOdrDeliverDateString() {
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd");;
		this.odrDeliverDateString=df.format(   new java.util.Date(  this.odrDeliverDate.getTime())      );
		return this.odrDeliverDateString;
	}

	public void setOdrDeliverDateString(String odrDeliverDateString) {
		this.odrDeliverDateString = odrDeliverDateString;
	}

	public List<SaleOrderLine> getSaleOrderLines() {
		return saleOrderLines;
	}

	public void setSaleOrderLines(List<SaleOrderLine> saleOrderLines) {
		this.saleOrderLines = saleOrderLines;
	}

	public SaleOrder() {
	}
	
	public SaleOrder(Long odrCustomerId, String odrCustomerName,
			String odrDeliverAddr, Date odrDeliverDate, String odrStatus) {
		this.odrCustomerId = odrCustomerId;
		this.odrCustomerName = odrCustomerName;
		this.odrDeliverAddr = odrDeliverAddr;
		this.odrDeliverDate = odrDeliverDate;
		this.odrStatus = odrStatus;
	}



	public Long getOdrId() {
		return this.odrId;
	}

	public void setOdrId(Long odrId) {
		this.odrId = odrId;
	}

	public Long getOdrCustomerId() {
		return this.odrCustomerId;
	}

	public void setOdrCustomerId(Long odrCustomerId) {
		this.odrCustomerId = odrCustomerId;
	}

	public String getOdrCustomerName() {
		return this.odrCustomerName;
	}

	public void setOdrCustomerName(String odrCustomerName) {
		this.odrCustomerName = odrCustomerName;
	}

	public String getOdrDeliverAddr() {
		return this.odrDeliverAddr;
	}

	public void setOdrDeliverAddr(String odrDeliverAddr) {
		this.odrDeliverAddr = odrDeliverAddr;
	}

	//将界面的String 的时间 格式转为   java.sql.Date
	public Date getOdrOrderDate() throws ParseException {
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		this.odrOrderDate=    new Date(df.parse(this.odrOrderDateString).getTime() );
		return this.odrOrderDate;
	}

	//当从数据库查询出时间的时候，mybatis会调用  setOdrOrderDate方法完成时间 的注入.
	//而  对应的 odrOrderDateString并没有值，所以等下  gson生成  json字符串时， 因为odrOrderDateString是null
	//所以返回给界面的  json中没有  odrOrderDateString,
	//解决方案： 在这个方法中强制调用一次  getOdrOrderDateString
	public void setOdrOrderDate(Date odrOrderDate) {
		this.odrOrderDate = odrOrderDate;
		this.getOdrOrderDateString();
	}

	public Date getOdrDeliverDate() throws ParseException {
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		this.odrDeliverDate=    new Date(df.parse(this.odrDeliverDateString).getTime() );
		return this.odrDeliverDate;
	}

	public void setOdrDeliverDate(Date odrDeliverDate) {
		this.odrDeliverDate = odrDeliverDate;
		this.getOdrDeliverDateString();
	}

	public String getOdrStatus() {
		return this.odrStatus;
	}

	public void setOdrStatus(String odrStatus) {
		this.odrStatus = odrStatus;
	}

	@Override
	public String toString() {
		return "SaleOrder [odrId=" + odrId + ", odrCustomerId=" + odrCustomerId
				+ ", odrCustomerName=" + odrCustomerName + ", odrDeliverAddr="
				+ odrDeliverAddr + ", odrOrderDate=" + odrOrderDate
				+ ", odrDeliverDate=" + odrDeliverDate + ", odrStatus="
				+ odrStatus + ", saleOrderLines=" + saleOrderLines + "]";
	}


}