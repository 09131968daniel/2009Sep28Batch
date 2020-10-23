package com.bank.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.bank.DAO.UserDAOim;

import com.bank.model.User;

public class LoginController {

	
	
	public static void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("I'm in login controller" );
		if (!request.getMethod().equals("POST"))  {
			System.out.println("That's a " + request.getMethod()+ " method, invalid method" );
			response.sendRedirect("http://localhost:8080/Reimbursment/api/");
		}
			else 
			{
				
				//login validation
				String username=request.getParameter("username");
				String password=request.getParameter("password");
				int ret=-1;	
				
				
				UserDAOim  ud= new UserDAOim();	
				ret= ud.LoginUser(username, password);
				  
				
				//login found
				  if (ret>0) {
					  //curent user
					 			 						   
					   HttpSession session=request.getSession();

					  session.setAttribute("username", username);
					  session.setAttribute("user_role_id", ret);
					  session.setAttribute("feed1","Welcome "+username);

					 
					  response.setStatus(300);
					  
					  response.sendRedirect("http://localhost:8080/Reimbursment/api/home");
				  }

		 	else  {
				  response.sendRedirect("http://localhost:8080/Reimbursment/api/home/failedlogin");
				  }
			}
	}
	

	public static void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		request.getSession().invalidate();
		response.sendRedirect("http://localhost:8080/Reimbursment/login.html");
	}



	}

