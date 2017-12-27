package com.justin.servlets;

import java.io.IOException;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 *  @author Justin Alderson
 * Logout will invalidate the session.
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private Logger logger;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		logger = Logger.getLogger(getServletName());
		
		response.setContentType("text/html");
		
		//Get the cookie to identify the session..
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for(Cookie cookie : cookies ){
				
				if(cookie.getName().equals("JSESSIONID")){
					
					logger.info("JSESSIONID= "+cookie.getValue());
					break;
					
				}
			}
			
			//Invalidate if exists, the session will be destroyed below..
			HttpSession session = request.getSession(false);
			
			logger.info("User= " + session.getAttribute("user"));
			
			if(session != null) {
				session.invalidate();
				
			}
			//forward to logged out page
			response.sendRedirect("loggedOut.html");
		}
	}

}
