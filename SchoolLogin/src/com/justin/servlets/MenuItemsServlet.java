package com.justin.servlets;

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ScheduleServlet
 *  @author Justin Alderson
 *  Deals with items selected from menu buttons. Some unimplemented.
 */
@WebServlet("/MenuItemsServlet")
public class MenuItemsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuItemsServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * Takes appropriate action depending on which button clicked.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String param = "";
		
		//Loop through all parameters, there should be only one. Set the variable and use to direct
		//to the correct page.
		Enumeration<String> en = request.getParameterNames();
		while(en.hasMoreElements()) {
			param = en.nextElement();
		}
		
		//Conditionals below check and the set page variable.
		if(param.equals("schedule")) {
			//Get context and forward on the page request.
			getServletContext().getRequestDispatcher("/schedule.jsp").forward(request, response);
		}else if(request.getParameter("new") == null) {
			//Send HTTP error as the other pages haven't been implemented.
			response.sendError(501, "I'm sorry, but this content hasn't been created yet.");
		
		}
		
	}

}
