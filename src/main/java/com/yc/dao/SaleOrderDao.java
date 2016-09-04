package com.yc.dao;

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

//�����ӿ�
public interface SaleOrderDao {
	/**
	 * ���ݶ����Ų鶩����������������
	 * @param saleOrder
	 * @return
	 */
	public SaleOrder get(SaleOrder saleOrder);

	/**
	 * ���ݶ����Ų鶩��������������
	 * @param id
	 * @return
	 */
	public SaleOrder getWithLines(Long id);
	
	
/**
 * ��Ӷ���
 * @param o
 */
	public void add(SaleOrder o);

	/**
	 * ��Ӷ�������
	 * @param o
	 */
	public void addDetail(SaleOrderLine o);

	/**
	 * ���ݱ��ɾ����������
	 * @param saleOrderLine
	 */
	public void delOrderLine(   SaleOrderLine saleOrderLine);
	
}
