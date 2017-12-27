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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AuthentificationFilter
 * @author Justin Alderson
 * Filter to ensure the authorized users are logged in.
 * 
 */
@WebFilter(filterName="/AuthentificationFilter", urlPatterns= {"/*"})
public class AuthentificationFilter implements Filter {

	//Used for application context with logging.
	private ServletContext context;

    /**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.context = fConfig.getServletContext();
		this.context.log("Authentification Filter Initialized.");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
		//narrowing
		HttpServletRequest servReq = (HttpServletRequest) request;
		HttpServletResponse servRespon = (HttpServletResponse) response;
		
		String uri = servReq.getRequestURI();
		
		//getSession() set to false to prevent a new session being created. Will return null if no session..
		//If no session exists and you want to have a session created, set true..
		HttpSession session = servReq.getSession(false);
		
		if(session == null && !(uri.endsWith("html") || uri.endsWith("LoginServlet"))) {
			
			this.context.log("Unauthorized access request");
			servRespon.sendRedirect("index.html");
			
		}else {
			
			// pass the request along the filter chain
			chain.doFilter(request, response);
			
		}
	}

}
