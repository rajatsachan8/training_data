import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)  
	        throws ServletException, IOException {  
	  
	    response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	          
	    String n=request.getParameter("username");  
	    String p=request.getParameter("userpass");  
	          System.out.println(n+"  "+p);
	    try {
			if(LoginDAO.validate(n, p)){  
			    RequestDispatcher rd=request.getRequestDispatcher("welcome.html");  
			    rd.forward(request,response);  
			}  
			else{  
			    out.print("Sorry username or password Invalid");  
			    RequestDispatcher rd=request.getRequestDispatcher("index.html");  
			    rd.include(request,response);  
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	          
	    out.close();  
	    }  
}
