package com.yc.web.actions;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;
import com.yc.bean.SaleOrder;
import com.yc.bean.SaleProduct;
import com.yc.biz.SaleOrderBiz;
import com.yc.biz.SaleProductBiz;
import com.yc.web.model.JsonModel;


@Controller
@Scope(value="prototype")

@Namespace("/")
@ParentPackage("struts-default")
public class SaleOrderAction extends BaseAction implements ModelDriven<SaleOrder>{
	private static final long serialVersionUID = 9128990787161714179L;

	
	//ÒµÎñ²ã
		private SaleOrderBiz saleOrderBiz;
		
		private JsonModel jsonModel=new JsonModel();
		
		private SaleOrder saleOrder;

		@Action(value = "/saleOrder_save")
		public void saleOrderSave() throws IOException{
			this.saleOrderBiz.add(     saleOrder  );
			jsonModel.setCode(1);
			ServletActionContext.getRequest().getSession().setAttribute("order", saleOrder);
			jsonModel.setObj(   saleOrder.getOdrId()    );
			super.outJson(jsonModel, ServletActionContext.getResponse());
		}
		
		@Action(value = "/saleOrder_findOrderWithDetail")
		public void findOrderWithDetail() throws IOException{
			saleOrder=this.saleOrderBiz.getWithLines(  saleOrder.getOdrId()  );
			jsonModel.setCode(1);
			jsonModel.setObj(  saleOrder    );
			super.outJson(jsonModel, ServletActionContext.getResponse());
		}
		
		@Action(value="/saleOrder_saveOrderLine")
		public void saleOrder_saveOrderLine() throws IOException{
			this.saleOrderBiz.addDetail(    this.saleOrder.getSaleOrderLine()      );
			jsonModel.setCode(1);
			super.outJson(jsonModel, ServletActionContext.getResponse());
		}
		
		
		@Action(value="/saleOrder_delOrderLine")
		public void saleOrder_delOrderLine() throws IOException{
			this.saleOrderBiz.delOrderLine(    this.saleOrder.getSaleOrderLine()      );
			jsonModel.setCode(1);
			super.outJson(jsonModel, ServletActionContext.getResponse());
		}

		@Resource(name="saleOrderBizImpl")
		public void setSaleOrderBiz(SaleOrderBiz saleOrderBiz) {
			this.saleOrderBiz = saleOrderBiz;
		}


		public SaleOrder getModel() {
			saleOrder=new SaleOrder();
			return saleOrder;
		}
		
		
}
