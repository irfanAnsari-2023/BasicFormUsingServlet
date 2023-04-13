package com.servletPractice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet  extends HttpServlet{
//	since the form is coming through post method so we will use doPost method
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		now, we will set the content of our response page
		response.setContentType("text/html");
		
//		 to print the same we will use PrintWriter 
		PrintWriter out = response.getWriter();
		out.println("<h1> Welcome To register servlet </h1>");
//		now we will fetch the register form detail one by one using req. object 
//		as all the data should be stored as req. object
		String name = request.getParameter("user_name");
		String password = request.getParameter("user_password");
		String email = request.getParameter("user_email");
		String gender = request.getParameter("user_gender");
		String course = request.getParameter("user_course");
		String condition  = request.getParameter("checkbox");
		if(condition != null) {
			if(condition.equals("checked")) {
				out.println("<h2> Name :" + name + "</h2>");
				out.println("<h2> Password :" + password + "</h2>");
				out.println("<h2> Email :" + email + "</h2>");
				out.println("<h2> Gender :" + gender + "</h2>");
				out.println("<h2> Course :" + course + "</h2>");
//				this will forward the request to the successServlet
				RequestDispatcher rd = request.getRequestDispatcher("Success");
				rd.forward(request, response);
			}
			else {
				out.println("<h2> You have not accepted terms and conditions!!</h2>");
				
			}
//			now we are implementing the practical of RequestDispatcher which has 2 methods
//			1. forward : it will take the req. and forwd. it to some other servlet 
//			and this servlet will provide the desired o/p.
//			2. include() : it will take the req. and forwd. it to some other servlet
//			and whatever the response will generate by this will taken by the prev. servlet and 
//			shown as the response of this servlet
			
		}else {
			out.println("<h2> You have not accepted terms and conditions!!</h2>");
			out.println("<h2> kindly do the same and try agian!!</h2>");
//			include method practical
//			get the obj. of requestDispatcher 
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);
		}
		
	}
	
}
