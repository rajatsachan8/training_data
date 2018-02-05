import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {
	
       protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
    	   response.setContentType("text/html;charset=UTF-8");
    	    
    	   String name=request.getParameter("username");
    	   String pass=request.getParameter("pass");
    	   System.out.println(name+ "   "+pass);
    	   response.sendRedirect("Welcome.html");
       }
}
