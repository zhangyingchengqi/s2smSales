package com.yc.biz;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.SelectKey;

import com.yc.bean.SaleOrder;
import com.yc.bean.SaleOrderLine;

public interface SaleOrderBiz {

	public SaleOrder get(SaleOrder saleOrder);

	public SaleOrder getWithLines(Long id);

	public void add(SaleOrder o);

	public void addDetail(SaleOrderLine o);

	public void delOrderLine(SaleOrderLine saleOrderLine);
}
