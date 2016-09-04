package com.yc.bean;

public class CusCustomer implements java.io.Serializable {

	private static final long serialVersionUID = 1026753053338812251L;
	
	private Long cusId;
	private String cusName;
	private String cusAddr;
	
	
	
	public CusCustomer() {
	}

	public CusCustomer(String cusName, String cusAddr) {
		this.cusName = cusName;
		this.cusAddr = cusAddr;
	}


	public Long getCusId() {
		return this.cusId;
	}

	public void setCusId(Long cusId) {
		this.cusId = cusId;
	}

	public String getCusName() {
		return this.cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public String getCusAddr() {
		return this.cusAddr;
	}

	public void setCusAddr(String cusAddr) {
		this.cusAddr = cusAddr;
	}

	@Override
	public String toString() {
		return "CusCustomer [cusId=" + cusId + ", cusName=" + cusName
				+ ", cusAddr=" + cusAddr + "]";
	}

}