package com.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * 
 * servlets
 * 		what is it?
 * 			A servlet is a java class to extend the capabilities of a server.
 * 		to create a servlet
 * 			1. extend the httpservlet abstract class
 * 			2. register it with tomcat through either
 * 				a. web.xml
 * 				b. annotations (@WebServlet(name = "direct", urlPatterns = {"/direct"}))
 * hierarchy of a servlet
 * 
 * 		Servlet (interface)
 * 			GenericServlet(AbstractClass)(AC)
 * 				HTTPServlet (AC)
 * 					CustomServlet(our class)
 * 
 * 		status codes
 * 			100 = informational
 * 			200 = ok
 * 			300 = redirect
 * 			400 = client side errors
 * 			500 = server side errors
 * 
 * 
 * 		Redirect
 * 			2 requests 2 responses
 * 		Forward
 * 			1 request 1 response
 * 		direct
 * 			1 request 1 response
 * 
 * 
 * 		http methods
 * 			get,post,put,delete,patch,head,options, etc...
 * 			
 * 		these methods are associated with crud methods
 * 			get = read
 * 			post = create
 * 			put = update
 * 			delete = delete
 * 			patch = update
 * 
 * 		head: just gets the headers of the response
 * 		options: sends an option request to make sure you're allowed, its used for the cors(?) handshake
 */

public class IndirectServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//redirect will change the url and send the user somewhere else
		//resp.sendRedirect("03-vscode/HTML/intro.html");
		//url stays the same, the server handles all information gathering
		req.getRequestDispatcher("03-vscode/HTML/login.html").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		if(username.equals("ahram")) {
			if(password.equals("pass")) {
				req.getRequestDispatcher("03-vscode/HTML/success.html").forward(req, resp);
			}else req.getRequestDispatcher("03-vscode/HTML/intro.html").forward(req, resp);
		} else req.getRequestDispatcher("03-vscode/HTML/intro.html").forward(req, resp);
	}


	
}
