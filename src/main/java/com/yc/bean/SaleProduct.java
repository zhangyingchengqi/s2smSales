package com.yc.bean;

public class SaleProduct implements java.io.Serializable {
	private static final long serialVersionUID = -6238391162854736966L;
	private Long prodId;
	private String prodName;
	private Double prodPrice;

	public String getString() {
		return this.prodName + "-" + this.prodPrice;
	}

	public SaleProduct() {
	}

	public SaleProduct(String prodName, Double prodPrice) {
		this.prodName = prodName;
		this.prodPrice = prodPrice;
	}

	public Long getProdId() {
		return this.prodId;
	}

	public void setProdId(Long prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return this.prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public Double getProdPrice() {
		return this.prodPrice;
	}

	public void setProdPrice(Double prodPrice) {
		this.prodPrice = prodPrice;
	}

}