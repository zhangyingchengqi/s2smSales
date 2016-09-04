package com.yc.web.actions;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.yc.web.model.JsonModel;

public abstract class BaseAction extends ActionSupport {

	private static final long serialVersionUID = -1598040769148528720L;
	
	public String parseJson( JsonModel jsonModel){
		Gson g=new Gson();
		return g.toJson(jsonModel);
	}

	public void outJson(JsonModel jsonModel, HttpServletResponse response) throws IOException {
		String json=parseJson( jsonModel);
		//øÁ”Ú
		response.setHeader("Access-Control-Allow-Origin","*");
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out=response.getWriter();
		out.println(   json);
		out.flush();
		out.close();
		
	}
	
	

}
