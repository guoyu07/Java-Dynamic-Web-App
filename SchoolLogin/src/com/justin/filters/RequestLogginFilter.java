package com.justin.filters;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class RequestLogginFilter
 * @author Justin Alderson
 * Logs all use of the application.
 */
@WebFilter(filterName="/RequestLogginFilter" , urlPatterns= {"/*"})
public class RequestLogginFilter implements Filter {

	private ServletContext context;
    
    /**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.context = fConfig.getServletContext();
		this.context.log("Request Logging Filter Initialized.");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		//
		HttpServletRequest servReq = (HttpServletRequest) request;
		
		Enumeration<String> params = servReq.getParameterNames();
		while(params.hasMoreElements()) {
			String name = params.nextElement();
			this.context.log(servReq.getRemoteAddr() + "::Request Params::{" + name + "=" + request.getParameter(name)+"}");
			
		}
		
		Cookie[] cookies = servReq.getCookies();
		if(cookies != null){
			for(Cookie cookie : cookies ){
				
				this.context.log(servReq.getRemoteAddr() + "::Cookie::{" + cookie.getName() + "," + cookie.getValue()+"}");
				
			}		
		}

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

}
