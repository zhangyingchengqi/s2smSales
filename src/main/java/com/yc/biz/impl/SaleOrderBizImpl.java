package com.yc.biz.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yc.bean.SaleOrder;
import com.yc.bean.SaleOrderLine;
import com.yc.biz.SaleOrderBiz;
import com.yc.dao.SaleOrderDao;
import com.yc.dao.mapper.SaleOrderMapper;

@Service
@Transactional(readOnly=true)
public class SaleOrderBizImpl implements SaleOrderBiz {
	private SaleOrderDao saleOrderDao;
	
	public SaleOrder get(SaleOrder saleOrder) {
		return this.saleOrderDao.get(saleOrder);
	}

	public SaleOrder getWithLines(Long id) {
		return this.saleOrderDao.getWithLines(id);
	}
	
	
	
	@Transactional(readOnly=false, isolation=Isolation.DEFAULT,rollbackForClassName={"java.lang.RuntimeException"},propagation=Propagation.REQUIRED)
	public void add(SaleOrder o) {
		this.saleOrderDao.add(o);
	}
	@Transactional(readOnly=false, isolation=Isolation.DEFAULT,rollbackForClassName={"java.lang.RuntimeException"},propagation=Propagation.REQUIRED)
	public void addDetail(SaleOrderLine o) {
		this.saleOrderDao.addDetail(o);
	}
	@Transactional(readOnly=false, isolation=Isolation.DEFAULT,rollbackForClassName={"java.lang.RuntimeException"},propagation=Propagation.REQUIRED)
	public void delOrderLine(SaleOrderLine saleOrderLine) {
		this.saleOrderDao.delOrderLine(saleOrderLine);
	}
	
	
	

	@Resource(name="saleOrderDaoMybatisImpl")
	public void setSaleOrderDao(SaleOrderDao saleOrderDao) {
		this.saleOrderDao = saleOrderDao;
	}

	
	
}
