package com.yc.dao.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.yc.bean.SaleOrder;
import com.yc.bean.SaleOrderLine;
import com.yc.dao.SaleOrderDao;
import com.yc.dao.mapper.SaleOrderMapper;

@Repository
public class SaleOrderDaoMybatisImpl implements SaleOrderDao {
	private SaleOrderMapper saleOrderMapper;

	public SaleOrder get(SaleOrder saleOrder) {
		return this.saleOrderMapper.get(saleOrder);
	}

	public SaleOrder getWithLines(Long id) {
		return this.saleOrderMapper.getWithLines(id);
	}

	public void add(SaleOrder o) {
		this.saleOrderMapper.add(o);
	}

	public void addDetail(SaleOrderLine o) {
		this.saleOrderMapper.addDetail(o);
	}

	public void delOrderLine(SaleOrderLine saleOrderLine) {
		this.saleOrderMapper.delOrderLine(saleOrderLine);
	}

	@Resource(name="saleOrderMapper")
	public void setSaleOrderMapper(SaleOrderMapper saleOrderMapper) {
		this.saleOrderMapper = saleOrderMapper;
	}

}
