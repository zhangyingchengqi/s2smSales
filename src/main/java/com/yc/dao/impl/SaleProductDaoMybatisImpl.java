package com.yc.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.yc.bean.SaleProduct;
import com.yc.dao.CusCustomerDao;
import com.yc.dao.SaleProductDao;

@Repository
public class SaleProductDaoMybatisImpl implements SaleProductDao {

	private SaleProductDao SaleProductMapper;
	
	public List<SaleProduct> findAll() {
		return this.SaleProductMapper.findAll();
	}
	
	@Resource(name="saleProductMapper")
	public void setSaleProductMapper(SaleProductDao saleProductMapper) {
		SaleProductMapper = saleProductMapper;
	}

}
