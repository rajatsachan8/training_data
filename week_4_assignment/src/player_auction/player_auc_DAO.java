package player_auction;

import java.sql.*;

public class player_auc_DAO {
	
		 static PreparedStatement stmt=null;
		 static Connection conn=null;
		 static ResultSet rs;
		 
	 
	 static void CreateConnection() throws SQLException{
		 try {
				Class.forName ("com.mysql.jdbc.Driver");
				//System.out.println("Connecting to a selected database...");
			     conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/player_db","root","Welcome123");
			     // System.out.println("Connected database successfully...");
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();	
			}
	 }
	 static void enter_player_database(String name,String category,int score,String figure,String team) throws SQLException{
		 try {
			CreateConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 String query="insert into player(Player_Name,Category,HighestScore,BestFigure) values(?,?,?,?)";
		 stmt = (PreparedStatement)conn.prepareStatement(query);
		 stmt.setString(1, name);
		 stmt.setString(2, category);
		 stmt.setInt(3, score);
		 stmt.setString(4,figure);
		 stmt.executeUpdate();
		// System.out.println("Player Table Updated");
		 update_team_player(name,team);
	 }
	  
	 static void update_team_player(String name,String Team) throws SQLException{
	    	  stmt=null;
	    	  String fetch_sql="select team_ID from team where Team_name=?";
	    	  stmt=(PreparedStatement)conn.prepareStatement(fetch_sql);
	    	  stmt.setString(1,Team);
	    	  
	    	  int team_ID = 0;
	    	  
	    	  rs=stmt.executeQuery();
	    	  while(rs.next()){
	    		  team_ID=rs.getInt("team_ID");
	    	  }
	    	  
	    	  stmt=null;
	    	  fetch_sql="select Player_No from player where Player_Name=?";
	    	  stmt=(PreparedStatement)conn.prepareStatement(fetch_sql);
	    	  stmt.setString(1,name);
	    	  
	    	  int player_no = 0;
	    	  
	    	  rs=stmt.executeQuery();
	    	  while(rs.next()){
	    		  player_no=rs.getInt("Player_No");
	    	  }
	    	  
	    	String set_sql="insert into team_player(Player_No,Team_Id) values(?,?)";
	    	stmt=(PreparedStatement)conn.prepareStatement(set_sql);
	    	stmt.setInt(1,player_no);
	    	stmt.setInt(2,team_ID);
	    	stmt.executeUpdate();
	    	System.out.println("Player added successfully with player No:"+player_no);
	      }
		 
	   void print_team_list(String team_name) throws SQLException{
		 stmt=null;
		 String get_query="select team_ID from team where Team_Name=?";
		 stmt=(PreparedStatement)conn.prepareStatement(get_query);
		 stmt.setString(1, team_name);
		 int t_id = 0;
		 rs=null;
		 rs=stmt.executeQuery();
		 while(rs.next()){
			 t_id=rs.getInt("team_ID");
		 }
		 get_query="select player.Player_name,player.Category from player inner join team_player on player.Player_No=team_player.player_No where team_player.Team_Id=? order by player.Player_name";
		 stmt=(PreparedStatement)conn.prepareStatement(get_query);
		 stmt.setInt(1, t_id);
		 rs=null;
		 rs=stmt.executeQuery();
		 System.out.println("Player Name                 Category");
		 System.out.println("--------------------------------------");
		 while(rs.next()){
			 String name=rs.getString("Player_Name");
			 String category=rs.getString("Category");
			 System.out.println(name+ "             "+category);
		 }
		 System.out.println();
	   }
	     boolean get_Duplicate(String player_name,String category,String team_name) throws SQLException{
	    	 String name;
	    	 String cat = null;
	    	 String team = null;
	    	 int playerno=0;
	    	CreateConnection();
	    	stmt=null;
	    	  String fetch_sql="select player.Player_No,player.category from player where Player_Name=?";
	    	  stmt=(PreparedStatement)conn.prepareStatement(fetch_sql);
	    	  stmt.setString(1,player_name);
	    	  
	    	  rs=stmt.executeQuery();
	    	  while(rs.next()){
	    		  playerno=rs.getInt("Player_No");
	    		  cat=rs.getString("category");	    	  
	    		  }
	    	  if(playerno==0 && cat==null){
	    		  return true;
	    	  }
	    	  else{
	    		  stmt=null;
	    		  fetch_sql="select team.Team_name from team inner join team_player on team.team_ID=team_player.Team_Id where Player_No=?";
	    		  stmt=(PreparedStatement)conn.prepareStatement(fetch_sql);
		    	  stmt.setInt(1,playerno);
		    	  rs=stmt.executeQuery();
		    	  while(rs.next()){
		    		  team=rs.getString("Team_name");
		    	  }
		    	  if(team.equals(team_name) && cat.equals(category)){
		    		  return false;
		    	  }
		    	  else {
		    		  return true;
		    	  }
	    	  }
	    	  
	     }
	     
		 
	 }


