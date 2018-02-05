package bookstore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO {
	
	static PreparedStatement stmt=null;
	 static Connection conn=null;
	 static ResultSet rs;

	 static void CreateConnection() throws SQLException{
		 try {
				Class.forName ("com.mysql.jdbc.Driver");
				//System.out.println("Connecting to a selected database...");
			     conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore_db","root","Welcome123");
			     // System.out.println("Connected database successfully...");
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();	
			}
	 }



    public ResultSet getresult(String categoryy) throws SQLException {
	// TODO Auto-generated method stub
	 List list=new ArrayList();
	  CreateConnection();
	  String query="select Book_id,Book_name,Author_name,Publisher,price from book where Category=?";
	  stmt=(PreparedStatement)conn.prepareStatement(query);
	  stmt.setString(1, categoryy);
	  rs=stmt.executeQuery();
	  
	return rs;
	
}




	public int getamount(int book_id) throws SQLException {
		CreateConnection();
		String query="select price from book where Book_id=?";
		stmt=(PreparedStatement)conn.prepareStatement(query);
		stmt.setInt(1, book_id);
		rs=stmt.executeQuery();
		while(rs.next()){
			int amount=rs.getInt("price");
			return amount;
		}
		return 0;
	}


}
