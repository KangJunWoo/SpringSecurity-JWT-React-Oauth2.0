
package com.project.jun.springsecurity;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletFilter implements Filter {
	
	public ServletFilter() {
	}
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		Filter.super.init(filterConfig);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("sevletfilter의 dofilter시작 전");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String authorization = req.getHeader("Authorization");
		System.out.println(authorization);
		chain.doFilter(req, res);
		System.out.println("sevletfilter의 dofilter시작 후");
	}
	@Override
	public void destroy() {
		Filter.super.destroy();
	}

}
