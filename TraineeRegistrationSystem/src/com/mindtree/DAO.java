package com.mindtree;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
	static PreparedStatement stmt=null;
	 static Connection conn=null;
	 static ResultSet rs;
	 
	 static void CreateConnection() throws SQLException{
		 try {
				Class.forName ("com.mysql.jdbc.Driver");
				//System.out.println("Connecting to a selected database...");
			     conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/trainee","root","Welcome123");
			     // System.out.println("Connected database successfully...");
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();	
			}
	 }
	  public void savedata(String firstName,String lastName,String email,String username,String password,String mid,String age,String city,String batch) throws SQLException {
		  
			  CreateConnection();
			String query="insert into traineedata(FirstName,LastName,Email,Username,Password,MID,Age,city,batch) values(?,?,?,?,?,?,?,?,?)";
			stmt=(PreparedStatement)conn.prepareStatement(query);
			stmt.setString(1, firstName);
			stmt.setString(2, lastName);
			stmt.setString(3, email);
			stmt.setString(4, username);
			stmt.setString(5, password);
			stmt.setString(6, mid);
			stmt.setString(7, age);
			stmt.setString(8, city);
			stmt.setString(9, batch);
            stmt.executeUpdate();			
		}
	public boolean validateUser(String username) throws SQLException {
		CreateConnection();
		String query="select username from traineedata where username=?";
		stmt=(PreparedStatement)conn.prepareStatement(query);
		stmt.setString(1, username);
		rs=stmt.executeQuery();
		int flag=0;
		while(rs.next()){
			flag=1;
		}
		if(flag==0)
		return true;
		else
			return false;
	}
	public boolean validateUsernamePassword(String username,String password) throws SQLException{
		CreateConnection();
		String query="select username from traineedata where username=? and password=?";
		stmt=(PreparedStatement)conn.prepareStatement(query);
		stmt.setString(1, username);
		stmt.setString(2, password);
		rs=stmt.executeQuery();
		int flag=0;
		while(rs.next()){
			flag=1;
		}
		if(flag!=0)
		return true;
		else
			return false;
	}
}
