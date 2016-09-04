package com.yc.web.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter {

	protected String encodingName;

	public CharacterEncodingFilter() {
		this.encodingName = "utf-8";
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		if( filterConfig.getInitParameter("encodingName")!=null){
			this.encodingName=filterConfig.getInitParameter("encodingName");
		}
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(    this.encodingName );
		chain.doFilter(request, response);
	}

	public void destroy() {
	}

}
