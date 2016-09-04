package com.yc.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;










import com.yc.bean.CusCustomer;
import com.yc.bean.SaleOrder;
import com.yc.bean.SaleProduct;
import com.yc.biz.CusCustomerBiz;
import com.yc.biz.SaleOrderBiz;
import com.yc.biz.SaleProductBiz;

import junit.framework.TestCase;

public class TestMybatis  {

	ApplicationContext ac;
	
	@Before
	public void init(){
		ac=new ClassPathXmlApplicationContext("beans_mybatis.xml");
	}
	
	@Test  // 业务层测试成功
	public void test1(){
		CusCustomerBiz ccb=(CusCustomerBiz) ac.getBean("cusCustomerBizImpl");
		List<CusCustomer> list=ccb.findAll();
		for( CusCustomer cc: list){
			System.out.println(  cc );
		}
	}
	
	@Test  // 业务层测试成功
	public void test2(){
		ac=new ClassPathXmlApplicationContext("beans_mybatis.xml");
		SaleProductBiz spb=(SaleProductBiz) ac.getBean("saleProductBizImpl");
		List<SaleProduct> list=spb.findAll();
		for( SaleProduct sp:list){
			System.out.println(  sp );
		}
	}
	
	
	@Test  // 业务层测试成功
	public void test3(){
		ac=new ClassPathXmlApplicationContext("beans_mybatis.xml");
		SaleOrderBiz spb=(SaleOrderBiz) ac.getBean("saleOrderBizImpl");
		SaleOrder so=spb.getWithLines(7L);
		System.out.println( so );
	}
}
