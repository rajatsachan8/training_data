import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet{
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String user = request.getParameter("username");
        String pass = request.getParameter("pass");
       
        if(user=="" || pass==""){
        	out.println("Username or Password Empty");
        }
        
        else try {
			if(Validate.checkUser(user, pass))
			{
			    RequestDispatcher rs = request.getRequestDispatcher("Welcome");
			    rs.forward(request, response);
			}
			else
			{
			   out.println("Username or Password Invalid");
			   RequestDispatcher rs = request.getRequestDispatcher("index.html");
			   rs.include(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }  
}
