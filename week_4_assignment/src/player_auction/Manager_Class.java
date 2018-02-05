package player_auction;
import com.mindtree.exceptions.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Manager_Class {
   
	 static Scanner scan=new Scanner(System.in);
	 InputStreamReader r=new InputStreamReader(System.in);    
	    BufferedReader br=new BufferedReader(r);       
	 public String category;
	 public int highest_score;
		public String player_name;
		public String team_name;
		public String best_figure;

		 player_auc_DAO access=new player_auc_DAO();
	
	

	public void access_nd_enterdb() throws SQLException, IOException {
		// TODO Auto-generated method stub
		System.out.print("Enter Player Name: ");
		   player_name=br.readLine();
		   while(true){
				try{
					System.out.print("Enter Category: ");
					category=scan.next();
					if(category.equals("Batsman")|| category.equals("Bowler")|| category.equals("Allrounder")){
						  break;
					  }
					  else
						 throw new InvalidCategoryException();
				 }
				 catch(InvalidCategoryException e){
					     System.out.println("Invalid category name please check your input");
			      }
		     }
		   
		   while(true){
			   try{
				   System.out.print("Enter Highest Score: ");
				   highest_score=scan.nextInt();
				 if((category.equals("Batsman")||category.equals("Bowler")||category.equals("Allrounder")) && highest_score>=50 && highest_score<=200){
					   break;
				   }
				   else throw new NotABatsmanException();
			   }
			   catch(NotABatsmanException e){
				   System.out.println("Invalid Batsman, please check your input");
			   }
			   catch(InputMismatchException e){
				   System.out.println("You entered a string");
				   scan=new Scanner(System.in);
			   }
		   }
		  while(true){
			  try{
				  System.out.print("Enter Best Figure: ");
				  best_figure=scan.next();
				  if(best_figure==null || (category.equals("Bowler")&& highest_score<0)){
					  throw new NotABowlerException();
				  }
				  int flag=0;
				  for(int i=0;i<best_figure.length();i++){
					  if(best_figure.charAt(i)=='/'){
						  flag=1;
					  }
				  }
				  
				  if(flag==0 || best_figure.charAt(0)=='/' || best_figure.charAt(best_figure.length()-1)=='/'){
					  throw new NotABowlerException();
				  }
				  break;
			  }
			  catch(NotABowlerException e){
				  System.out.println("Invalid Bowler, please check your input");
			  }
		  }
		  
		  while(true){
			  try{

				  System.out.print("Enter Team Name: ");
				  team_name=scan.next();
				  if(team_name.equals("CSK")|| team_name.equals("RCB") || team_name.equals("MI")||team_name.equals("RR")||team_name.equals("SRH")||team_name.equals("KKR")){
					  break;
				  }
				  else throw new InvalidTeamNameException();
			  }
			  catch(InvalidTeamNameException e){
				  System.out.println("Invalid team name, please check your input");
			  }
		  }
		  
		  try{
			  boolean result=access.get_Duplicate(player_name,category,team_name);
			  if(!result){
				  throw new DuplicateEntryException();
			  }
			  access.enter_player_database(player_name, category, highest_score, best_figure, team_name);
		  }
			  catch(DuplicateEntryException e){
				  System.out.println("Player details already exist in the database");
			  }
		  
	}







	public void search_db() throws SQLException {
		// TODO Auto-generated method stub
		while(true){
			try{
				System.out.print("Enter team name: ");
				   team_name=scan.next();
				   
				   if(team_name.equals("CSK")|| team_name.equals("RCB") || team_name.equals("MI")||team_name.equals("RR")||team_name.equals("SRH")||team_name.equals("KKR")){
						  break;
					  }
					  else throw new InvalidTeamNameException();
				  }
				  catch(InvalidTeamNameException e){
					  System.out.println("Invalid team name, please check your input");
				  }
		}
		access.print_team_list(team_name);
		   
		
	}
}

