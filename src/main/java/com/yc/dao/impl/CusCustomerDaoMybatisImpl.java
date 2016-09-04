package com.yc.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.yc.bean.CusCustomer;
import com.yc.dao.CusCustomerDao;

@Repository
public class CusCustomerDaoMybatisImpl implements CusCustomerDao {
	
	private CusCustomerDao cusCustomerMapper;

	public List<CusCustomer> findAll() {
		return this.cusCustomerMapper.findAll();
	}

	@Resource(name="cusCustomerMapper")
	public void setCusCustomerMapper(CusCustomerDao cusCustomerMapper) {
		this.cusCustomerMapper = cusCustomerMapper;
	}
	
	
	

}
