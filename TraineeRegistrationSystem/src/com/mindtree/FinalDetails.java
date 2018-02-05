package com.mindtree;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FinalDetails extends HttpServlet{
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	resp.setContentType("text/html");
    	ServletContext context=getServletContext();
    	
    	String firstname=(String)context.getAttribute("firstName");
    	String lastname=(String)context.getAttribute("lastName");
    	String email=(String)context.getAttribute("email");
    	String username=(String)context.getAttribute("username");
    	String password=(String)context.getAttribute("password");
    	String mid=(String)context.getAttribute("mid");
    	String age=(String)context.getAttribute("age");
    	String city=(String)context.getAttribute("city");
    	String batch=(String)context.getAttribute("batch");
    	DAO access=new DAO();
    	try {
			access.savedata(firstname, lastname, email, username, password,mid,age,city,batch);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	RequestDispatcher dispatch=req.getRequestDispatcher("index.html");
    	dispatch.forward(req, resp);
    }
}
