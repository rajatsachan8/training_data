package com.mindtree;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {
	
	static String firstName;
	static String lastName;
	static String email;
	static String userName;
	static String password;
    
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=UTF-8");
		
		firstName=req.getParameter("firstName");
		lastName=req.getParameter("lastName");
		email=req.getParameter("email");
		userName=req.getParameter("userName");
		password=req.getParameter("password");
		StringBuilder str=new StringBuilder();
		PrintWriter out=resp.getWriter();
		Validation validate=new Validation();
		int result = 0;
		try {
			result = validate.firstServletValidate(firstName, lastName, userName, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ServletContext context=getServletContext();
		if(result==0){
			
			context.setAttribute("firstName", firstName);
	        context.setAttribute("lastName", lastName);
	        context.setAttribute("email", email);
	        context.setAttribute("username", userName);
	        context.setAttribute("password", password);
			   RequestDispatcher rs = req.getRequestDispatcher("trainee2.jsp");
			   rs.forward(req, resp);
		}
		context.removeAttribute("msg1");
		context.removeAttribute("msg2");
		context.removeAttribute("msg3");
		context.removeAttribute("msg4");
		if(result==1){
			   context.setAttribute("msg1", "Firstname should only contain alphabet");
			   //str=str.append("Firstname should only contain alphabet<br>");
		}
		if(result==2){
			context.setAttribute("msg2", "Firstname should only contain alphabet");
			   //str=str.append("Firstname should only contain alphabet<br>");
		}
		if(result==3){
			context.setAttribute("msg3", "Password length should be greater than 8");
			   //str=str.append("Password length should be greater than 8");
		}
		if(result==4)
		{
			context.setAttribute("msg4", "Username already taken");
			//str=str.append("Username already taken");
		}
		System.out.println(str);
		//out.println("<h3>"+str.toString()+"</h3");
		RequestDispatcher rs = req.getRequestDispatcher("trainee.jsp");
		   rs.include(req, resp);
	}
}
