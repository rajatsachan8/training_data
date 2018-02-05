package commandline;

import java.sql.*;
import java.util.*;

public class College_JDBC {
	

	   static PreparedStatement stmt=null;
	   static Connection conn=null;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		try {
			Class.forName ("com.mysql.jdbc.Driver");
			System.out.println("Connecting to a selected database...");
		     conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","Welcome123");
		      System.out.println("Connected database successfully...");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}
		
		Scanner scan=new Scanner(System.in);
		System.out.println("enter id");
		int n=scan.nextInt();
		System.out.println("enter name");
		String str=scan.next();
		
		 
		String sql = "INSERT INTO id_name(ID,Name) values(?,?)";
		 stmt = (PreparedStatement)conn.prepareStatement(sql);
		 stmt.setInt(1, n);
		 stmt.setString(2, str);     		 
         stmt.executeUpdate();
    System.out.println("Table updated");
	}

}
