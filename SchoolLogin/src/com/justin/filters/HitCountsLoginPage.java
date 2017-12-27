package com.justin.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class HitCountsLoginPage
 * @author Justin Alderson
 * Counts the number of successful logins for the life of the application.
 * Outputs information to log.
 */
@WebFilter(filterName="/HitCountsLoginPage", urlPatterns={"/loginSuccess.jsp"})
public class HitCountsLoginPage implements Filter {

	//Used for application context with logging
	private ServletContext context;
	private int hits;
    
    /**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.context = fConfig.getServletContext();
		this.context.log("Hit Count Filter Initialized.");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 * hits will be incremented for every call received
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		hits++;
		this.context.log("Number of successful logins: " + hits);
		// pass the request along the filter chain
		chain.doFilter(request, response);
		
	}

}
