package com.yc.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.type.JdbcType;

import com.yc.bean.SaleOrder;
import com.yc.bean.SaleOrderLine;

@CacheNamespace(size = 512)
public interface SaleOrderMapper {

	@Select("select * from sale_order where odr_id=#{odrId}")
	@Options(useCache = true, flushCache = false, timeout = 10000)
	@Results(value = {
			@Result(id = true, property = "odrId", column = "odr_id"),
			@Result(property = "odrCustomerId", column = "odr_customer_id"),
			@Result(property = "odrCustomerName", column = "odr_customer_name"),
			@Result(property = "odrDeliverAddr", column = "odr_deliver_addr"),
			@Result(property = "odrOrderDate", column = "odr_order_date", javaType = java.sql.Date.class, jdbcType = JdbcType.DATE),
			@Result(property = "odrDeliverDate", column = "odr_deliver_date", javaType = java.sql.Date.class, jdbcType = JdbcType.DATE),
			@Result(property = "odrStatus", column = "odr_status") })
	public SaleOrder get(SaleOrder saleOrder);

	@Select("select * from sale_order where odr_id=#{id}")
	@Options(useCache = true, flushCache = false, timeout = 10000)
    @Results({  
    	@Result(id = true, property = "odrId", column = "odr_id"),
		@Result(property = "odrCustomerId", column = "odr_customer_id"),
		@Result(property = "odrCustomerName", column = "odr_customer_name"),
		@Result(property = "odrDeliverAddr", column = "odr_deliver_addr"),
		@Result(property = "odrOrderDate", column = "odr_order_date", javaType = java.sql.Date.class, jdbcType = JdbcType.DATE),
		@Result(property = "odrDeliverDate", column = "odr_deliver_date", javaType = java.sql.Date.class, jdbcType = JdbcType.DATE),
		@Result(property = "odrStatus", column = "odr_status"),  
        @Result(property="saleOrderLines",column="odr_id",many=@Many(select="com.yc.dao.mapper.SaleOrderMapper.findOrderLineByOrder"))  
    }) 
	public SaleOrder getWithLines(Long id);
	
	

	@Insert("insert into sale_order( odr_customer_id,odr_customer_name,odr_deliver_addr,odr_order_date,odr_deliver_date,odr_status) values(#{odrCustomerId}, #{odrCustomerName} ,#{odrDeliverAddr},#{odrOrderDate},#{odrDeliverDate}  ,#{odrStatus} )")
	@SelectKey(keyProperty="odrId",keyColumn="odr_id",before=false, resultType = Long.class, statement = { "select max(odr_id) from sale_order" })
	public void add(SaleOrder o);

	@Insert(" insert into sale_order_line(odl_order_id, odl_product_name,odl_product_price,odl_product_count) values(#{saleOrder.odrId}, #{odlProductName},#{odlProductPrice},#{odlProductCount})")
	public void addDetail(SaleOrderLine o);

	@Delete("delete from sale_order_line where odl_id=#{odlId}")
	public void delOrderLine(   SaleOrderLine saleOrderLine);
	
	@Select(value = { "select * from sale_order_line where odl_order_id=#{odrid}" })
	@Results(value = {
			@Result(id = true, property = "odlId", column = "odl_id"),
			@Result(property = "odlProductName", column = "odl_product_name"),
			@Result(property = "odlProductPrice", column = "odl_product_price"),
			@Result(property = "odlProductCount", column = "odl_product_count") })
	public List<SaleOrderLine> findOrderLineByOrder(  Integer odrid  );
}
