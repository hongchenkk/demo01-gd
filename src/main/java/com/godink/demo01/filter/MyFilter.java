package com.godink.demo01.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyFilter implements Filter{
	
	private String name;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		Filter.super.init(filterConfig);
		log.info("MyFilter init...");
		log.info("init参数-name:{}", filterConfig.getInitParameter("name"));
		name = filterConfig.getInitParameter("name");
	}

	@Override
	public void doFilter(ServletRequest srequest, ServletResponse sresponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) srequest;
		log.info("this is MyFileter,url:{}" , request.getRequestURI());
		log.info("doFilter-init参数-name:{}" , name);
		chain.doFilter(srequest, sresponse);
	}
	
	@Override
	public void destroy() {
		Filter.super.destroy();
		log.info("MyFilter destroy...");
	}

}
