package com.mindtree.spring.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DAO {

	static PreparedStatement stmt=null;
	 static Connection conn=null;
	 static ResultSet rs;
 static Statement st;
	 static void CreateConnection() throws SQLException{
		 try {
				Class.forName ("com.mysql.jdbc.Driver");
				//System.out.println("Connecting to a selected database...");
			     conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring_assignment1","root","Welcome123");
			     // System.out.println("Connected database successfully...");
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();	
			}
	 }
	 

	public void send_data(String id, String username, String password, String doj, String email, String role,
			String projectid) throws SQLException {
		CreateConnection();
		int ID=Integer.parseInt(id);
		int project_id=Integer.parseInt(projectid);
		
		String query="insert into user(id,username,password,DOJ,email_id,role,project_id) values(?,?,?,?,?,?,?)";
		stmt=conn.prepareStatement(query);
		stmt.setInt(1, ID);
		stmt.setString(2, username);
		stmt.setString(3, password);
		stmt.setString(4, doj);
		stmt.setString(5,email);
		stmt.setString(6, role);
		stmt.setInt(7, project_id);
		stmt.execute();
		conn.close();
		System.out.println("values updated");
		
	}


	public void send_intoProject(String projectid, String projectName, String description, String estimated_time) throws SQLException {
		// TODO Auto-generated method stub
		CreateConnection();
		int pid=Integer.parseInt(projectid);
		int time=Integer.parseInt(estimated_time);
		
		String query="insert into project(project_id,project_name,project_desc,estimated_hrs) values(?,?,?,?)";
		stmt=conn.prepareStatement(query);
		stmt.setInt(1, pid);
		stmt.setString(2, projectName);
        stmt.setString(3, description);	
        stmt.setInt(4, time);
        stmt.execute();
        conn.close();
        System.out.println("Values updated");
	}


	public ResultSet getproject() throws SQLException {
		// TODO Auto-generated method stub
		CreateConnection();
		  String query="select * from project";
		  st=conn.createStatement();
		  	 
		  rs=st.executeQuery(query);
		  
		  return rs;
	}


	public ResultSet getUsers() throws SQLException {
		CreateConnection();
		String query="select * from user";
		st=conn.createStatement();
		rs=st.executeQuery(query);
		return rs;
		
	}


	public ResultSet getUsersById(int id) throws SQLException {
		CreateConnection();
		String query="select * from user where id=?";
		stmt=conn.prepareStatement(query);
		stmt.setInt(1, id);
		rs=stmt.executeQuery();
		return rs;
	}


	public Boolean checkuser(String userName, String string) throws SQLException {
		CreateConnection();
		String query="select * from user where username=?";
		stmt=conn.prepareStatement(query);
		stmt.setString(1, userName);
		rs=stmt.executeQuery();
		if(rs.next()){
			if(rs.getString("password").equals(string))
			return true;
			else 
				return false;
		}
		else 
		{
			return false;
			
		}
	}


	public void updatepassword(String current_user, String pass) throws SQLException {
		CreateConnection();
		String query="update user set password=? where username=?";
		stmt=conn.prepareStatement(query);
		stmt.setString(1,pass);
		stmt.setString(2, current_user);
        stmt.execute();
        conn.close();
		
	}


	


	public Boolean validate_user(String username, String email) throws SQLException {
		// TODO Auto-generated method stub
		CreateConnection();
		String query="select * from user where username=?";
		stmt=conn.prepareStatement(query);
		stmt.setString(1, username);
		rs=stmt.executeQuery();
		if(rs.next()){
			System.out.println("inside if");
				return false;
		}
		else 
		{
			System.out.println("inside else");
			return true;
		}
	}


	public Boolean validate_email(String email) throws SQLException {
		CreateConnection();
		String query="select * from user where email_id=?";
		stmt=conn.prepareStatement(query);
		stmt.setString(1, email);
		rs=stmt.executeQuery();
		if(rs.next()){
			System.out.println("inside if");
				return false;
		}
		else 
		{
			System.out.println("inside else");
			return true;
		}
	}
	 
	 
}
