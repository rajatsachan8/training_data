import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
	static PreparedStatement stmt=null;
	 static Connection conn=null;
	 static ResultSet rs;

	 static void CreateConnection() throws SQLException{
		 try {
				Class.forName ("com.mysql.jdbc.Driver");
				//System.out.println("Connecting to a selected database...");
			     conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/logincheck","root","Welcome123");
			     // System.out.println("Connected database successfully...");
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();	
			}
	 }
	 
	 public static boolean validate(String name,String pass) throws SQLException{  
		 boolean status=false;
		 try{
			 CreateConnection();
			 String query="select * from logindata where name=? and password=?";
			 stmt=(PreparedStatement)conn.prepareStatement(query);
			 stmt.setString(1, name);
			 stmt.setString(2, pass);
			 rs=stmt.executeQuery();
			 	status=rs.next();
			 	 
		 }
		 catch(Exception e){
			 System.out.println(e);
		 }
		 return status;
	 }
}
