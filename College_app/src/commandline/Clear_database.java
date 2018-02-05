package commandline;
import java.sql.*;

public class Clear_database {
    
	static Statement stmt=null;
	   static Connection conn=null;
	   
	   static final String JDBC_Driver="com.mysql.jdbc.Driver";
	   static final String DB_url="jdbc:mysql://localhost:3306/college";
	   
	   static final String user="root";
	   static final String pass="Welcome123";
	   
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("Connecting to database...");
		try {
			Class.forName ("com.mysql.jdbc.Driver");
			System.out.println("Connecting to a selected database...");
		     conn = DriverManager.getConnection(DB_url,user,pass);
		      System.out.println("Connected database successfully...");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}
		 System.out.println("Deleting records into the table...");
		 String sql = "delete from id_marks where id>0";
	stmt.executeUpdate(sql);
		 System.out.println("Table ID_Marks cleared");
		   sql="delete from id_name where id>0";
		   stmt.executeUpdate(sql);
		   System.out.println("Table ID_Name cleared");
		 
	}

}
