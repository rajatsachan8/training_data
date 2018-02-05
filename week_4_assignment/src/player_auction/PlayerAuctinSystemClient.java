package player_auction;

import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PlayerAuctinSystemClient {
	

	public static void main(String[] args) throws SQLException, IOException {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
          int option = 0;
          Manager_Class mngr=new Manager_Class();
          while(true){
        	  try{
        		  do{
                	  System.out.println("------Player Auction Menu------");
                	  System.out.println("1.Add a Player");
                	  System.out.println("2.Display Players");
                	  System.out.println("3.Exit");
                	  
                			  option=scan.nextInt();
                		    if(option<1 || option>3){
                		    	throw new InputMismatchException("dump");
                		    }
                		    
                	   if(option==1){
                		  System.out.println("     Add a Player     ");
                		  System.out.println("-----------------------");
                		  mngr.access_nd_enterdb();
                		   
                	   }
                	   if(option==2){
                		   System.out.println("     Display Players!!    ");
                		   System.out.println("----------------------------");
                		  mngr.search_db();
                	   }
              
                  }while(option!=3 || option==1 || option==2);
                  
                  System.out.println("Player Auction Ends...."); 
                  break;
        	  }
        	  catch(InputMismatchException e){
        		  System.out.println("Wrong Input Entered");
        		  scan=new Scanner(System.in);
        	  }
          }
         
	}

}
