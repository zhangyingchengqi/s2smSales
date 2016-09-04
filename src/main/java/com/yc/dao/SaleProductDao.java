package com.yc.dao;

import java.util.List;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.yc.bean.SaleProduct;

@CacheNamespace(size = 512) 
public interface SaleProductDao {
	
	@Select("select * from Sale_Product")
	@Options(useCache = true, flushCache = false, timeout = 10000)  
    @Results(value = {  
            @Result(id = true, property = "prodId", column = "prod_id"),  
            @Result(property = "prodName", column = "prod_name"),
            @Result(property = "prodPrice", column = "prod_price")
           
    })  
	public List<SaleProduct> findAll();
}
