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
import com.yc.bean.SaleProduct;
import com.yc.biz.SaleProductBiz;
import com.yc.web.model.JsonModel;


@Controller
@Scope(value="prototype")
@Namespace("/")
@ParentPackage("struts-default")
public class SaleProductAction extends BaseAction {
	private static final long serialVersionUID = 9128990787161714179L;

	
	//ÒµÎñ²ã
		private SaleProductBiz saleProductBiz;
		
		private JsonModel jsonModel=new JsonModel();
		
		@Action(value = "/saleProduct_findAll")
		public void findAll() throws IOException{
			if( saleProductBiz==null){
				jsonModel.setCode(0);
				jsonModel.setMsg("server internal error");
			}else{
				List<SaleProduct> list=this.saleProductBiz.findAll();
				ServletActionContext.getRequest().getSession().setAttribute("saleProductList", list);
				
				jsonModel.setCode(1);
				jsonModel.setObj(list);   //  id,  uname
			}
			super.outJson( jsonModel,  ServletActionContext.getResponse() );
		}

		@Resource(name="saleProductBizImpl")
		public void setSaleProductBiz(SaleProductBiz saleProductBiz) {
			this.saleProductBiz = saleProductBiz;
		}
		
		
}
