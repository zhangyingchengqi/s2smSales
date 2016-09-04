package com.yc.dao;

import java.util.List;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import com.yc.bean.CusCustomer;

@CacheNamespace(size = 512) 
public interface CusCustomerDao {

	@Select("select * from cus_customer")
	@Options(useCache = true, flushCache = false, timeout = 10000)  
    @Results(value = {  
            @Result(id = true, property = "cusId", column = "cus_id"),  
            @Result(property = "cusName", column = "cus_name"),
            @Result(property = "cusAddr", column = "cus_addr")
           
    })  
	public List<CusCustomer> findAll();
}
