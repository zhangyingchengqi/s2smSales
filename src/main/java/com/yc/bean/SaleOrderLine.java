package com.yc.bean;

public class SaleOrderLine  implements java.io.Serializable {
	private static final long serialVersionUID = 5234127736211637617L;
	
	private Long odlId;
     private SaleOrder saleOrder;      // odl_order_id
     private String odlProductName;
     private Double odlProductPrice;
     private Integer odlProductCount;



    public SaleOrderLine() {
    }

    
    public SaleOrderLine(SaleOrder saleOrder, String odlProductName, Double odlProductPrice, Integer odlProductCount) {
        this.saleOrder = saleOrder;
        this.odlProductName = odlProductName;
        this.odlProductPrice = odlProductPrice;
        this.odlProductCount = odlProductCount;
    }

    public Long getOdlId() {
        return this.odlId;
    }
    
    public void setOdlId(Long odlId) {
        this.odlId = odlId;
    }

    public SaleOrder getSaleOrder() {
        return this.saleOrder;
    }
    
    public void setSaleOrder(SaleOrder saleOrder) {
        this.saleOrder = saleOrder;
    }

    public String getOdlProductName() {
        return this.odlProductName;
    }
    
    public void setOdlProductName(String odlProductName) {
        this.odlProductName = odlProductName;
    }

    public Double getOdlProductPrice() {
        return this.odlProductPrice;
    }
    
    public void setOdlProductPrice(Double odlProductPrice) {
        this.odlProductPrice = odlProductPrice;
    }

    public Integer getOdlProductCount() {
        return this.odlProductCount;
    }
    
    public void setOdlProductCount(Integer odlProductCount) {
        this.odlProductCount = odlProductCount;
    }
   








}