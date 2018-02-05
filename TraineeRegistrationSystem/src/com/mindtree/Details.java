package com.mindtree;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Details extends HttpServlet {
	static String MId;
    static String age;
    static String city;
    static String batch;
    
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	resp.setContentType("text/html;charset=UTF-8");
    	   MId=req.getParameter("mindtreeid");
    	   age=req.getParameter("age");
    	   city=req.getParameter("city");
    	   batch=req.getParameter("batch");
    	   PrintWriter out=resp.getWriter();
    	   int result=0;
    	   result=Validation.BatchMidValidation(MId,city);
    	   if(result==0){
    		   ServletContext context=getServletContext();
        	   context.setAttribute("mid", MId);
        	   context.setAttribute("age", age);
        	   context.setAttribute("city", city);
        	   context.setAttribute("batch", batch);
        	   RequestDispatcher rs = req.getRequestDispatcher("finaldetails.jsp");
    		   rs.forward(req, resp);
    	   }
    	   if(result==1){
    		   out.println("<h3>MID should contain M in starting</h3>");
    	   }
    	   if(result==2){
    		   out.println("<h3>City should contain alphabest only</h3>");
    	   }
    	   RequestDispatcher rs = req.getRequestDispatcher("trainee2.jsp");
		   rs.include(req, resp);
        
    }
    
}
