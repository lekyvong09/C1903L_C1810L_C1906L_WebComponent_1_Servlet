package com.ray.citymanager.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletParameters2
 */
@WebServlet("/servletparameters2")
public class ServletParameters2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletParameters2() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get servlet init parameter
		String secretCode = getServletConfig().getInitParameter("secretCode");
		
		// get global init (application param)
		String dbURL = getServletContext().getInitParameter("dbURL");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String outString = String.format("Secret Code: %s\nDB URL: %s \n"
				, (secretCode == null? "unauthorized" : secretCode)
				, dbURL);
		
		out.println("<html><body>" + outString + "</body></html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
