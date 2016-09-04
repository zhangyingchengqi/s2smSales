package com.yc.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yc.bean.CusCustomer;
import com.yc.biz.CusCustomerBiz;
import com.yc.dao.CusCustomerDao;

@Service
@Transactional(readOnly=true)
public class CusCustomerBizImpl implements CusCustomerBiz {
	
	private CusCustomerDao cusCustomerDao;

	public List<CusCustomer> findAll() {
		return this.cusCustomerDao.findAll();
	}

	@Resource(name="cusCustomerDaoMybatisImpl")
	public void setCusCustomerDao(CusCustomerDao cusCustomerDao) {
		this.cusCustomerDao = cusCustomerDao;
	}
	
	

}
