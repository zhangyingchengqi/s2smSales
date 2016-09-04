package com.yc.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yc.bean.SaleProduct;
import com.yc.biz.SaleProductBiz;
import com.yc.dao.SaleProductDao;

@Service
@Transactional(readOnly=true)
public class SaleProductBizImpl implements SaleProductBiz {
	private SaleProductDao saleProductDao;

	public List<SaleProduct> findAll() {
		return this.saleProductDao.findAll();
	}

	@Resource(name="saleProductDaoMybatisImpl")
	public void setSaleProductDao(SaleProductDao saleProductDao) {
		this.saleProductDao = saleProductDao;
	}
	
	

}
