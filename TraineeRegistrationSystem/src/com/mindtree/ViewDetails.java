package com.mindtree;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewDetails extends HttpServlet {
     static String username;
     static String password;
     static String designation;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		username=req.getParameter("username");
		password=req.getParameter("password");
		designation=req.getParameter("designation");
		ServletContext context=getServletContext();  
		if(designation.equals("Admin"))
		{
			if(username.equals(context.getInitParameter("Username")) && password.equals(context.getInitParameter("Password")) ){
				RequestDispatcher rs = req.getRequestDispatcher("admin_table.jsp");
				   rs.forward(req, resp);
			}
			else{
				out.println("<h1>Wrong Username or Password</h1>");
				RequestDispatcher rs = req.getRequestDispatcher("View.jsp");
				   rs.include(req, resp);
			}
		}
		if(designation.equals("Trainee")){
			DAO dao=new DAO();
			try {
				if(dao.validateUsernamePassword(username, password)){
					context.setAttribute("User_name", username);
					RequestDispatcher rs = req.getRequestDispatcher("trainee_table.jsp");
					   rs.forward(req, resp);
				}
				else{
					out.println("<h1>User does not exist</h1>");
					RequestDispatcher rs = req.getRequestDispatcher("View.jsp");
					   rs.include(req, resp);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
