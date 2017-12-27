package com.justin.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 * @author Justin Alderson
 * Checks to see if the user is author is a registered user.
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	//Temporary user and passwords for testing.
	private String userId = "user";
	private String password ="password";
       
    /**
     * @see HttpServlet#HttpServlet()
     * Login will be checked to see if the user is valid.
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * Set cookies and session timeout if registered user.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userLocal = request.getParameter("user");
		String passwordLocal = request.getParameter("pwd");
		
		if(userId.equals(userLocal) && password.equals(passwordLocal)) {
			
			HttpSession session = request.getSession();
			///Set session to expire after.. 3 mins
			session.setMaxInactiveInterval(3*60);
			//Create a cookie with the name of the user..
			Cookie cookie = new Cookie("user",userLocal);
			//Cookie will be destroyed after the below time...
			cookie.setMaxAge(3*60);
			response.addCookie(cookie);
			response.sendRedirect("loginSuccess.jsp");
			
		}else {
			
			//Send to page incorrect details...
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
			PrintWriter out = response.getWriter();
			out.println("<font color=red>Either user name or password is incorrect.</font>");
			rd.include(request, response);
			
		}
	}
}
